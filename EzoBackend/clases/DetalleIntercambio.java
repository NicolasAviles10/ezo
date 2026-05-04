package clases;
import java.util.UUID;

public class DetalleIntercambio {
    private UUID           idDetalle;
    private UUID          idIntercambio;   
    private UUID           idCopia;        
    private int           cantidad;
   
    public DetalleIntercambio() {}

    public UUID           getIdDetalle()      { return idDetalle; }
    public UUID          getIdIntercambio()  { return idIntercambio; }
    public UUID           getIdCopia()        { return idCopia; }
    public int           getCantidad()       { return cantidad; }
    
    public void setIdDetalle(UUID id)            { this.idDetalle = id; }
    public void setIdIntercambio(UUID id)        { this.idIntercambio = id; }
    public void setIdCopia(UUID id)              { this.idCopia = id; }
    public void setCantidad(int cantidad)       { this.cantidad = cantidad; }
}
