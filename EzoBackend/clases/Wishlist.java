package clases;
import java.util.UUID;

public class Wishlist {
    private UUID          idWishlist;
    private UUID          idUsuario;   
    
    public Wishlist() {}

    public UUID          getIdWishlist() { return idWishlist; }
    public UUID          getIdUsuario()  { return idUsuario; }
    

    public void setIdWishlist(UUID id)        { this.idWishlist = id; }
    public void setIdUsuario(UUID id)         { this.idUsuario = id; }
}
