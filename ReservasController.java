package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Compra;
import connection.DBConnection;

public class ReservasController implements IReservasController {

@Override
    public String listarReservas(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.ruta, l.placa, l.fecha, l.hora, l.valor l.puestos from servicio l "
                + "inner join compra a on l.ruta = a.ruta inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> viajes = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String factura = rs.getString("factura");
                String ruta = rs.getString("ruta");
                String username2 = rs.getString("username");

                Compra compra = new Compra(factura, ruta, username2);

                viajes.add(gson.toJson(compra));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(viajes);
    }
}