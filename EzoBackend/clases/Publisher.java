package clases;
import java.time.LocalDate;
import java.util.UUID;

public class Publisher {
    private UUID      idPublisher;
    private String    nombre;
    private UUID      idPais;
    private LocalDate fechaFundacion;

    public Publisher() {}

    public UUID      getIdPublisher()   { return idPublisher; }
    public String    getNombre()        { return nombre; }
    public UUID      getIdPais()        { return idPais; }
    public LocalDate getFechaFundacion(){ return fechaFundacion; }

    public void setIdPublisher(UUID id)       { this.idPublisher = id; }
    public void setNombre(String nombre)     { this.nombre = nombre; }
    public void setIdPais(UUID idPais)        { this.idPais = idPais; }
    public void setFechaFundacion(LocalDate f){ this.fechaFundacion = f; }

    @Override public String toString() {
        return "{\"id_publisher\":" + idPublisher + ",\"nombre\":\"" + nombre + "\"}";
    }
}
