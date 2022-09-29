
package beans;

import java.sql.Date;

public class Compra    {
    private String factura;
    private String ruta;
    private String username;

    public Compra(String factura, String ruta, String username) {
        this.factura = factura;
        this.ruta = ruta;
        this.username = username;
    }



    public String getFactura() {
        return factura;
    }

    public String getRuta() {
        return ruta;
    }

    public String getUsername() {
        return username;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Compra{" + "factura=" + factura + ", ruta=" + ruta + ", username=" + username + '}';
    }


}
