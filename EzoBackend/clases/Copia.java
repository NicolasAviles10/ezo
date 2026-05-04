package clases;

import java.util.UUID;

public class Copia {
    private UUID    idCopia;
    private UUID    idArticulo;   
    private String codigoUnico;
    private String expansion;
    private String estado;       
    private String tipo;
    private UUID    idUsuario;    

    public Copia() {}

    public UUID    getIdCopia()      { return idCopia; }
    public UUID    getIdArticulo()   { return idArticulo; }
    public String getCodigoUnico()  { return codigoUnico; }
    public String getExpansion()    { return expansion; }
    public String getEstado()       { return estado; }
    public String getTipo()         { return tipo; }
    public UUID    getIdUsuario()    { return idUsuario; }

    public void setIdCopia(UUID id)           { this.idCopia = id; }
    public void setIdArticulo(UUID id)        { this.idArticulo = id; }
    public void setCodigoUnico(String c)     { this.codigoUnico = c; }
    public void setExpansion(String e)       { this.expansion = e; }
    public void setEstado(String estado)     { this.estado = estado; }
    public void setTipo(String tipo)         { this.tipo = tipo; }
    public void setIdUsuario(UUID id)         { this.idUsuario = id; }

    @Override public String toString() {
        return "{\"id_copia\":" + idCopia + ",\"id_articulo\":" + idArticulo +
               ",\"estado\":\"" + estado + "\",\"id_usuario\":" + idUsuario + "}";
    }
}
