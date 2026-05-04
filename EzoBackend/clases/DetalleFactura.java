package clases;
import java.math.BigDecimal;
import java.util.UUID;

public class DetalleFactura {
    private UUID        idDetalleFactura;
    private UUID        idFactura;       
    private String     descripcion;
    private int        cantidad;
    private BigDecimal precioUnitario;

    public DetalleFactura() {}

    public UUID        getIdDetalleFactura() { return idDetalleFactura; }
    public UUID        getIdFactura()        { return idFactura; }
    public String     getDescripcion()      { return descripcion; }
    public int        getCantidad()         { return cantidad; }
    public BigDecimal getPrecioUnitario()   { return precioUnitario; }

    public void setIdDetalleFactura(UUID id)     { this.idDetalleFactura = id; }
    public void setIdFactura(UUID id)            { this.idFactura = id; }
    public void setDescripcion(String d)        { this.descripcion = d; }
    public void setCantidad(int c)              { this.cantidad = c; }
    public void setPrecioUnitario(BigDecimal p) { this.precioUnitario = p; }
}
