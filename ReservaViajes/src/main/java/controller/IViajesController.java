package controller;

public interface IViajesController {

    public String listar(boolean ordenar, String orden);

    public String devolver(String ruta, String username);
    
    public String sumarCantidad(String ruta);

}
