
package beans;

import java.sql.Date;
import java.sql.Time;

public class Servicio {
    private String ruta;
    private String placa;
    private Date fecha;
    private Time hora;
    private double valor;
    private int puestos;

    public Servicio(String ruta, String placa, Date fecha, Time hora, double valor, int puestos) {
        this.ruta = ruta;
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.puestos = puestos;
    }


    
    public String getRuta() {
        return ruta;
    }

    public String getPlaca() {
        return placa;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public double getValor() {
        return valor;
    }

    public int isPuestos() {
        return puestos;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }

    @Override
    public String toString() {
        return "Servicio{" + "ruta=" + ruta + ", placa=" + placa + ", fecha=" + fecha + ", hora=" + hora + ", valor=" + valor + ", puestos=" + puestos + '}';
    }


}
