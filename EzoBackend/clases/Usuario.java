package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Usuario {

    private UUID          idCuenta;
    private String        nombreUsuario;
    private String        email;
    private UUID          idPais;          
    private String        passwordHash;
    private String        nombre;
    private String        apellido;
    private LocalDate     fechaNacimiento;
    private String        telefono;
    private String        rol;             
    private LocalDateTime fechaRegistro;
    private boolean       emailVerificado;
    private boolean       activo;

    public Usuario() {}

    public UUID          getIdCuenta()       { return idCuenta; }
    public String        getNombreUsuario()  { return nombreUsuario; }
    public String        getEmail()          { return email; }
    public UUID          getIdPais()         { return idPais; }
    public String        getPasswordHash()   { return passwordHash; }
    public String        getNombre()         { return nombre; }
    public String        getApellido()       { return apellido; }
    public LocalDate     getFechaNacimiento(){ return fechaNacimiento; }
    public String        getTelefono()       { return telefono; }
    public String        getRol()            { return rol; }
    public LocalDateTime getFechaRegistro()  { return fechaRegistro; }
    public boolean       isEmailVerificado() { return emailVerificado; }
    public boolean       isActivo()          { return activo; }

    public void setIdCuenta(UUID idCuenta)                { this.idCuenta = idCuenta; }
    public void setNombreUsuario(String nombreUsuario)   { this.nombreUsuario = nombreUsuario; }
    public void setEmail(String email)                   { this.email = email; }
    public void setIdPais(UUID idPais)                    { this.idPais = idPais; }
    public void setPasswordHash(String passwordHash)     { this.passwordHash = passwordHash; }
    public void setNombre(String nombre)                 { this.nombre = nombre; }
    public void setApellido(String apellido)             { this.apellido = apellido; }
    public void setFechaNacimiento(LocalDate f)          { this.fechaNacimiento = f; }
    public void setTelefono(String telefono)             { this.telefono = telefono; }
    public void setRol(String rol)                       { this.rol = rol; }
    public void setFechaRegistro(LocalDateTime f)        { this.fechaRegistro = f; }
    public void setEmailVerificado(boolean emailVerif)   { this.emailVerificado = emailVerif; }
    public void setActivo(boolean activo)                { this.activo = activo; }

    @Override
    public String toString() {
        return "{\"id_cuenta\":" + idCuenta +
               ",\"nombre_usuario\":\"" + nombreUsuario + "\"" +
               ",\"email\":\"" + email + "\"" +
               ",\"rol\":\"" + rol + "\"" +
               ",\"activo\":" + activo + "}";
    }
}
