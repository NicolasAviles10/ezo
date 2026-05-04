package clases;
import java.time.LocalDateTime;
import java.util.UUID;

public class Mensaje {
    private UUID          idMensaje;
    private UUID          idUsuarioEmisor;   
    private UUID          idUsuarioReceptor; 
    private String        mensaje;
    private LocalDateTime fechaEmision;

    public Mensaje() {}

    public UUID          getIdMensaje()          { return idMensaje; }
    public UUID          getIdUsuarioEmisor()    { return idUsuarioEmisor; }
    public UUID          getIdUsuarioReceptor()  { return idUsuarioReceptor; }
    public String        getMensaje()            { return mensaje; }
    public LocalDateTime getFechaEmision()       { return fechaEmision; }

    public void setIdMensaje(UUID id)              { this.idMensaje = id; }
    public void setIdUsuarioEmisor(UUID id)        { this.idUsuarioEmisor = id; }
    public void setIdUsuarioReceptor(UUID id)      { this.idUsuarioReceptor = id; }
    public void setMensaje(String mensaje)        { this.mensaje = mensaje; }
    public void setFechaEmision(LocalDateTime f)  { this.fechaEmision = f; }
}
