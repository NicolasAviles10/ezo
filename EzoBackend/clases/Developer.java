package clases;
import java.time.LocalDate;
import java.util.UUID;

public class Developer {
    private UUID      idDeveloper;
    private String    nombre;
    private UUID       idPais;
    private LocalDate fechaFundacion;

    public Developer() {}

    public UUID       getIdDeveloper()    { return idDeveloper; }
    public String    getNombre()         { return nombre; }
    public UUID       getIdPais()         { return idPais; }
    public LocalDate getFechaFundacion() { return fechaFundacion; }

    public void setIdDeveloper(UUID id)         { this.idDeveloper = id; }
    public void setNombre(String nombre)       { this.nombre = nombre; }
    public void setIdPais(UUID idPais)          { this.idPais = idPais; }
    public void setFechaFundacion(LocalDate f) { this.fechaFundacion = f; }

    @Override public String toString() {
        return "{\"id_developer\":" + idDeveloper + ",\"nombre\":\"" + nombre + "\"}";
    }
}
