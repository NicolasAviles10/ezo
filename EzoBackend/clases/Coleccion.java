package clases;
import java.time.LocalDate;
import java.util.UUID;

public class Coleccion {
    private UUID       idColeccion;
    private String    nombre;
    private UUID       idPublisher;  
    private LocalDate fecha;

    public Coleccion() {}

    public UUID       getIdColeccion() { return idColeccion; }
    public String    getNombre()      { return nombre; }
    public UUID       getIdPublisher() { return idPublisher; }
    public LocalDate getFecha()       { return fecha; }

    public void setIdColeccion(UUID id)      { this.idColeccion = id; }
    public void setNombre(String nombre)    { this.nombre = nombre; }
    public void setIdPublisher(UUID id)      { this.idPublisher = id; }
    public void setFecha(LocalDate fecha)   { this.fecha = fecha; }
}
