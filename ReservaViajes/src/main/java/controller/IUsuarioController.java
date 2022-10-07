package controller;

import java.util.Map;

public interface IUsuarioController {
    
    public String login (String username , String clave);
    
    public String register(String username, String clave, String nombre, String apellidos, String email, double saldo);
    
    public String pedir(String username);
    
    public String modificar(String username, String nuevaContrasena, 
            String nuevoNombre, String nuevosApellidos, String nuevoEmail, 
            double nuevoSaldo);
    
    public String eliminar(String username);
   
}
