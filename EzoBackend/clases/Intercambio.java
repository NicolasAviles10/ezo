package clases;
import java.time.LocalDateTime;
import java.util.UUID;

public class Intercambio {
    private UUID          idIntercambio;
    private LocalDateTime fecha;
    private UUID          idUsuarioOrigen;   
    private UUID          idUsuarioDestino;  
    private String        estado;            
    private LocalDateTime fechaCompletado;

    public Intercambio() {}

    public UUID          getIdIntercambio()    { return idIntercambio; }
    public LocalDateTime getFecha()            { return fecha; }
    public UUID          getIdUsuarioOrigen()  { return idUsuarioOrigen; }
    public UUID          getIdUsuarioDestino() { return idUsuarioDestino; }
    public String        getEstado()           { return estado; }
    public LocalDateTime getFechaCompletado()  { return fechaCompletado; }

    public void setIdIntercambio(UUID id)          { this.idIntercambio = id; }
    public void setFecha(LocalDateTime f)         { this.fecha = f; }
    public void setIdUsuarioOrigen(UUID id)        { this.idUsuarioOrigen = id; }
    public void setIdUsuarioDestino(UUID id)       { this.idUsuarioDestino = id; }
    public void setEstado(String estado)          { this.estado = estado; }
    public void setFechaCompletado(LocalDateTime f){ this.fechaCompletado = f; }

    @Override public String toString() {
        return "{\"id_intercambio\":" + idIntercambio +
               ",\"id_usuario_origen\":" + idUsuarioOrigen +
               ",\"id_usuario_destino\":" + idUsuarioDestino +
               ",\"estado\":\"" + estado + "\"}";
    }
}
