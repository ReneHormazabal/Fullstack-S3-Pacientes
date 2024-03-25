package ejerciciob.ejerciciob.classes;

public class Atencion {
    private int id;
    private String fecha;
    private String hora;
    private String descripcion;
    private String diagnostico;
    private String tratamiento;
    private String nombreMedico;
    
    // Constructor
    public Atencion(int id, String fecha, String hora, String descripcion, String diagnostico, String tratamiento, String nombreMedico) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.nombreMedico = nombreMedico;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }
}
