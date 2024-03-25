package ejerciciob.ejerciciob.classes;

import java.util.List;

public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String prevision;
    private List<Atencion> atenciones;

    // Constructor
    public Paciente(int id, String nombre, int edad, String prevision, List<Atencion> atenciones) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.prevision = prevision;
        this.atenciones = atenciones;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        if (edad < 0) {
            return 0;
        }
        return edad;
    }

    public String getPrevision() {
        return prevision;
    }

    public List<Atencion> getAtenciones() {
        return atenciones;
    }
}