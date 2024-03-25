package ejerciciob.ejerciciob.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ejerciciob.ejerciciob.classes.Atencion;
import ejerciciob.ejerciciob.classes.ErrorResponse;
import ejerciciob.ejerciciob.classes.Paciente;

@RestController
public class PacienteController {


    private List<Paciente> pacientes = new ArrayList<Paciente>();

    public PacienteController(){
        pacientes.add(new Paciente(1, "Juan Perez", 25, "Fonasa", Arrays.asList(new Atencion(1, "2024-01-01", "10:00", "Dolor de cabeza", "Migraña", "Tomar paracetamol", "Dr. Juanito Perez"), new Atencion(4, "2024-01-02", "13:00", "Dolor de cabeza", "Covid", "Tomar paracetamol", "Dr. Simi"), new Atencion(5, "2024-01-01", "15:00", "Tos", "Resfrío", "Tomar paracetamol", "Dr. Dencil"))));
        pacientes.add(new Paciente(2, "Maria Rojas", 30, "Banmedica", Arrays.asList(new Atencion(2, "2024-01-02", "11:00", "Dolor de estomago", "Gastritis", "Tomar omeprazol", "Dr. Juanito Perez"))));
        pacientes.add(new Paciente(3, "Raul Gonzalez", 45, "Colmena", Arrays.asList(new Atencion(3, "2024-01-01", "12:00", "Dolor de espalda", "Contractura", "Tomar relajante muscular", "Dr. Juanito Perez"))));
        pacientes.add(new Paciente(4, "Pedro Perez", 35, "Fonasa", null));
    }

    
    @GetMapping("/pacientes")
    public ResponseEntity<?> getAllPacientes() {

        //Si la lista no viene vacía, se retornan los pacientes
        if (!pacientes.isEmpty()) { 
            System.out.println("Se ingresa a /pacientes y se retornan los pacientes 🚀");
            return ResponseEntity.ok(pacientes);
        //Si la lista viene vacía, se retorna un error
        } else { 
            System.out.println("Se ingresa a /pacientes y no se encontraron pacientes ❌");
            ErrorResponse err = new ErrorResponse("No se encontraron pacientes", 404);
            return ResponseEntity.status(404).body(err);
            
        }
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        //Se recorre la lista de pacientes y se compara el id, si se encuentra se retorna el paciente con sus atenciones
        for (Paciente paciente : pacientes) { 
            if (paciente.getId() == id) {
                System.out.println("Se ingresa a /pacientes/id y se retorna el usuario: " + paciente.getId() + " 🙍‍♂️");
                return ResponseEntity.ok(paciente);
            }
        }
        //Si no se encuentra el usuario, se retorna un error
        System.out.println("Se ingresa a /pacientes/id, no se encuentra el paciente ❌");
        ErrorResponse err = new ErrorResponse("No se encontraron pacientes con el id: " + id, 404);
        return ResponseEntity.status(404).body(err);
    }

    @GetMapping("/atenciones/{date}")
    public ResponseEntity<?> getPacientesPorFecha(@PathVariable String date) {
        List<Paciente> pacientesEnFecha = new ArrayList<>();
    
        // Se recorre la lista de pacientes
        for (Paciente paciente : pacientes) {
            List<Atencion> atencionesEnFecha = new ArrayList<>();
    
            // Se verifica que el paciente tenga atenciones
            if (paciente.getAtenciones() != null) {
                // Se recorren las atenciones del paciente
                for (Atencion atencion : paciente.getAtenciones()) {
                    // Si la fecha de la atención coincide con la proporcionada, se añade a la lista
                    if (atencion.getFecha().equals(date)) {
                        atencionesEnFecha.add(atencion);
                    }
                }
            }
    
            // Si el paciente tiene atenciones en esa fecha, se añade a la lista de pacientesEnFecha
            if (!atencionesEnFecha.isEmpty()) {
                Paciente pacienteConAtencionesEnFecha = new Paciente(paciente.getId(), paciente.getNombre(), paciente.getEdad(), paciente.getPrevision(), atencionesEnFecha);
                pacientesEnFecha.add(pacienteConAtencionesEnFecha);
            }
        }
    
        // Se verifica si se encontraron pacientes con atenciones en la fecha indicada
        if (!pacientesEnFecha.isEmpty()) {
            System.out.println("Se ingresa a /atenciones/date y se retornan los pacientes con atenciones en la fecha: " + date + " 📅");
            return ResponseEntity.ok(pacientesEnFecha);
        } else {
            ErrorResponse err = new ErrorResponse("No se encontraron pacientes con atenciones en la fecha: " + date, 404);
            return ResponseEntity.status(404).body(err);
        }
    }



}
