package clases;

import java.util.UUID;

public class MetodoPago {
    private UUID    idMetodoPago;
    private String nombreMetodo;

    public MetodoPago() {}

    public UUID    getIdMetodoPago() { return idMetodoPago; }
    public String getNombreMetodo() { return nombreMetodo; }
    public void   setIdMetodoPago(UUID id) { this.idMetodoPago = id; }
    public void   setNombreMetodo(String n) { this.nombreMetodo = n; }
}
