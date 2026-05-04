package clases;
import java.time.LocalDateTime;
import java.util.UUID;

public class Sesion {
    private UUID          idSesion;
    private UUID          idUsuario;      
    private String        tokenRefresh;
    private String        ipAddress;
    private LocalDateTime fechaExpiracion;

    public Sesion() {}

    public UUID          getIdSesion()       { return idSesion; }
    public UUID          getIdUsuario()      { return idUsuario; }
    public String        getTokenRefresh()   { return tokenRefresh; }
    public String        getIpAddress()      { return ipAddress; }
    public LocalDateTime getFechaExpiracion(){ return fechaExpiracion; }

    public void setIdSesion(UUID id)              { this.idSesion = id; }
    public void setIdUsuario(UUID id)             { this.idUsuario = id; }
    public void setTokenRefresh(String t)        { this.tokenRefresh = t; }
    public void setIpAddress(String ip)          { this.ipAddress = ip; }
    public void setFechaExpiracion(LocalDateTime f){ this.fechaExpiracion = f; }
}
