package clases;

import java.util.UUID;

public class Pais {
    private UUID    idPais;
    private String nombre;

    public Pais() {}
    public Pais(UUID idPais, String nombre) { this.idPais = idPais; this.nombre = nombre; }
    public UUID    getIdPais()  { return idPais; }
    public String getNombre()  { return nombre; }
    public void   setIdPais(UUID idPais)    { this.idPais = idPais; }
    public void   setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() { return "{\"id_pais\":" + idPais + ",\"nombre\":\"" + nombre + "\"}"; }
}
