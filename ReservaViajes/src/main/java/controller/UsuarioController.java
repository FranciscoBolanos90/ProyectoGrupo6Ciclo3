package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;


public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String clave) {

        Gson gson = new Gson();
        DBConnection con=new DBConnection();

        String sql = "SELECT * FROM usuario WHERE  username= '" + username
                + "' and clave = '" + clave + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double saldo=rs.getDouble("saldo");

                Usuario usuario = new Usuario(username, clave, nombre, apellidos,email,saldo);
                
                return gson.toJson(usuario);
                
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
        
        return "false";
    }
    
@Override
    public String register(String username, String clave, String nombre , String apellidos, String email, double saldo){
        
        Gson gson = new Gson();
        DBConnection con=new DBConnection();
        
        String sql = "INSERT INTO usuario (username , clave , nombre , apellidos,email, saldo)"
                + " values('" + username + "','"+ clave +"' , '"+ nombre 
                +"' ,'"+ apellidos + "' , '"+ email +"',"+ saldo + ")";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            Usuario usuario = new Usuario(username , clave, nombre , apellidos , email, saldo);
            
            st.close();
            
            return gson.toJson(usuario);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
    
}
