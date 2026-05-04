package clases;
import java.time.LocalDateTime;
import java.util.UUID;

public class Wishlist {
    private UUID          idWishlist;
    private UUID          idUsuario;   
    private UUID          idArticulo;  
    private LocalDateTime fecha;
    private int           prioridad;

    public Wishlist() {}

    public UUID          getIdWishlist() { return idWishlist; }
    public UUID          getIdUsuario()  { return idUsuario; }
    public UUID          getIdArticulo() { return idArticulo; }
    public LocalDateTime getFecha()      { return fecha; }
    public int           getPrioridad()  { return prioridad; }

    public void setIdWishlist(UUID id)        { this.idWishlist = id; }
    public void setIdUsuario(UUID id)         { this.idUsuario = id; }
    public void setIdArticulo(UUID id)        { this.idArticulo = id; }
    public void setFecha(LocalDateTime f)    { this.fecha = f; }
    public void setPrioridad(int prioridad)  { this.prioridad = prioridad; }
}
