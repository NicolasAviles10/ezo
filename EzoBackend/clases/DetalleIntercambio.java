package clases;
import java.time.LocalDateTime;
import java.util.UUID;

public class DetalleIntercambio {
    private UUID           idDetalle;
    private UUID          idIntercambio;   
    private UUID           idCopia;        
    private UUID           cantidad;
    private LocalDateTime fechaEntrega;
    private String        estado;

    public DetalleIntercambio() {}

    public UUID           getIdDetalle()      { return idDetalle; }
    public UUID          getIdIntercambio()  { return idIntercambio; }
    public UUID           getIdCopia()        { return idCopia; }
    public UUID           getCantidad()       { return cantidad; }
    public LocalDateTime getFechaEntrega()   { return fechaEntrega; }
    public String        getEstado()         { return estado; }

    public void setIdDetalle(UUID id)            { this.idDetalle = id; }
    public void setIdIntercambio(UUID id)        { this.idIntercambio = id; }
    public void setIdCopia(UUID id)              { this.idCopia = id; }
    public void setCantidad(UUID cantidad)       { this.cantidad = cantidad; }
    public void setFechaEntrega(LocalDateTime f){ this.fechaEntrega = f; }
    public void setEstado(String estado)        { this.estado = estado; }
}
