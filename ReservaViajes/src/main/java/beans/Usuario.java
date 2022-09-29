
package beans;

public class Usuario {
    private String username;
    private String clave;
    private String nombre;
    private String apellidos;
    private String email;
    private double saldo;

    public Usuario(String username, String clave, String nombre, String apellidos, String email, double saldo) {
        this.username = username;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.saldo = saldo;
    }

   
    
    public String getUsername() {
        return username;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", clave=" + clave + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", saldo=" + saldo + '}';
    }


    
    
}
