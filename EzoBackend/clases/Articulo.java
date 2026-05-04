package clases;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Articulo {
    private UUID        idArticulo;
    private String     nombre;
    private LocalDate  fechaLanzamiento;
    private String     descripcion;
    private String     tamanio;
    private BigDecimal precio;
    private String     tipo;
    private UUID       idPublisher;   
    private UUID       idDeveloper;
    private Boolean    disponible;    

    public Articulo() {}

    public UUID        getIdArticulo()      { return idArticulo; }
    public String     getNombre()          { return nombre; }
    public LocalDate  getFechaLanzamiento(){ return fechaLanzamiento; }
    public String     getDescripcion()     { return descripcion; }
    public String     getTamanio()         { return tamanio; }
    public BigDecimal getPrecio()          { return precio; }
    public String     getTipo()            { return tipo; }
    public UUID       getIdPublisher()     { return idPublisher; }
    public UUID       getIdDeveloper()     { return idDeveloper; }
    public Boolean    getDisponible()     { return disponible; }

    public void setIdArticulo(UUID id)             { this.idArticulo = id; }
    public void setNombre(String nombre)          { this.nombre = nombre; }
    public void setFechaLanzamiento(LocalDate f)  { this.fechaLanzamiento = f; }
    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
    public void setTamanio(String tamanio)        { this.tamanio = tamanio; }
    public void setPrecio(BigDecimal precio)      { this.precio = precio; }
    public void setTipo(String tipo)              { this.tipo = tipo; }
    public void setIdPublisher(UUID idPublisher)   { this.idPublisher = idPublisher; }
    public void setIdDeveloper(UUID idDeveloper)   { this.idDeveloper = idDeveloper; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }

    @Override public String toString() {
        return "{\"id_articulo\":" + idArticulo + ",\"nombre\":\"" + nombre +
               "\",\"precio\":" + precio + ",\"tipo\":\"" + tipo + "\"}";
    }
}
