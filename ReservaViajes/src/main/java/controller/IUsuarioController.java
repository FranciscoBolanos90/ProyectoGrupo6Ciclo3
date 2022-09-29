package controller;

public interface IUsuarioController {
    
    public String login (String username , String clave);
    
    public String register(String username, String clave, String nombre, String apellidos, String email, double saldo);
}
