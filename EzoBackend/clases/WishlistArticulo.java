import java.util.UUID;
import java.time.LocalDateTime;

public class WishlistArticulo {
    private UUID          idWishlistArticulo;
    private UUID          idWishlist;   
    private UUID          idArticulo;   
    private LocalDateTime fecha; 
    private int           prioridad; 

    public WishlistArticulo() {}

    public UUID          getIdWishlistArticulo() { return idWishlistArticulo; }
    public UUID          getIdWishlist()         { return idWishlist; }
    public UUID          getIdArticulo()         { return idArticulo; }
    public LocalDateTime getFecha()              { return fecha; }
    public int           getPrioridad()         { return prioridad; }

    public void setIdWishlistArticulo(UUID id)   { this.idWishlistArticulo = id; }
    public void setIdWishlist(UUID id)           { this.idWishlist = id; }
    public void setIdArticulo(UUID id)           { this.idArticulo = id; }
    public void setFecha(LocalDateTime f)        { this.fecha = f; }
    public void setPrioridad(int prioridad)      { this.prioridad = prioridad; }
}