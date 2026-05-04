package clases;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Factura {
    private UUID       idFactura;
    private String     numeroFactura;
    private String     razonSocialEmp;
    private UUID       idUsuario;     
    private BigDecimal impuesto;
    private BigDecimal total;
    private String     estado;
    private LocalDate  fechaVencimiento;
    private LocalDate  fechaEmision;
    private BigDecimal subtotal;
    private String     nitEmpresa;
    private String     nit;
    private String     razonSocial;

    public Factura() {}

    public UUID       getIdFactura()        { return idFactura; }
    public String     getNumeroFactura()    { return numeroFactura; }
    public String     getRazonSocialEmp()   { return razonSocialEmp; }
    public UUID       getIdUsuario()        { return idUsuario; }
    public BigDecimal getImpuesto()         { return impuesto; }
    public BigDecimal getTotal()            { return total; }
    public String     getEstado()           { return estado; }
    public LocalDate  getFechaVencimiento() { return fechaVencimiento; }
    public LocalDate  getFechaEmision()     { return fechaEmision; }
    public BigDecimal getSubtotal()         { return subtotal; }
    public String     getNitEmpresa()       { return nitEmpresa; }
    public String     getNit()              { return nit; }
    public String     getRazonSocial()      { return razonSocial; }

    public void setIdFactura(UUID id)               { this.idFactura = id; }
    public void setNumeroFactura(String n)         { this.numeroFactura = n; }
    public void setRazonSocialEmp(String r)        { this.razonSocialEmp = r; }
    public void setIdUsuario(UUID id)               { this.idUsuario = id; }
    public void setImpuesto(BigDecimal imp)        { this.impuesto = imp; }
    public void setTotal(BigDecimal total)         { this.total = total; }
    public void setEstado(String estado)           { this.estado = estado; }
    public void setFechaVencimiento(LocalDate f)   { this.fechaVencimiento = f; }
    public void setFechaEmision(LocalDate f)       { this.fechaEmision = f; }
    public void setSubtotal(BigDecimal sub)        { this.subtotal = sub; }
    public void setNitEmpresa(String n)            { this.nitEmpresa = n; }
    public void setNit(String nit)                 { this.nit = nit; }
    public void setRazonSocial(String r)           { this.razonSocial = r; }
}
