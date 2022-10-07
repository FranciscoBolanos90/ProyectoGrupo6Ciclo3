package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.google.gson.Gson;
import beans.Servicio;
import connection.DBConnection;
import java.sql.Time;

public class ViajesController implements IViajesController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from servicio";

        if (ordenar == true) {
            sql += " order by fecha " + orden;
        }

        List<String> servicios = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String ruta = rs.getString("ruta");
                String placa = rs.getString("placa");
                Date fecha= rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                double valor = rs.getDouble("valor");
                int puestos=rs.getInt("puestos");

                Servicio servicio = new Servicio(ruta, placa, fecha, hora, valor, puestos);

                servicios.add(gson.toJson(servicio));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(servicios);

    }
    
    @Override
    public String devolver(String ruta, String username) {

        DBConnection con = new DBConnection();
        String sql = "Delete from compra where ruta= " + ruta + " and username = '" 
                + username + "' limit 1";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeQuery(sql);

            this.sumarCantidad(ruta);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String sumarCantidad(String ruta) {

        DBConnection con = new DBConnection();

        String sql = "Update servicio set puestos = (Select puestos from servicio where ruta = " 
                + ruta + ") + 1 where ruta = " + ruta;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }
}