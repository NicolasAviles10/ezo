import java.util.UUID;
import java.time.LocalDateTime;

public class Comentario  {
    private UUID          idResena;
    private UUID          idArticulo;   
    private UUID          idUsuario;   
    private LocalDateTime fecha; 
    private int           puntacion;
    private String        comentario; 

    public Comentario() {}

    public UUID          getIdResena()     { return idResena; }
    public UUID          getIdArticulo()   { return idArticulo; }
    public UUID          getIdUsuario()    { return idUsuario; }
    public LocalDateTime getFecha()       { return fecha; }
    public int           getPuntacion()   { return puntacion; }
    public String        getComentario()   { return comentario; }


    public void setIdResena(UUID id)        { this.idResena = id; }
    public void setIdArticulo(UUID id)      { this.idArticulo = id; }
    public void setIdUsuario(UUID id)       { this.idUsuario = id; }
    public void setFecha(LocalDateTime f)   { this.fecha = f; }
    public void setPuntacion(int p)        { this.puntacion = p; }
    public void setComentario(String c)     { this.comentario = c; }
}