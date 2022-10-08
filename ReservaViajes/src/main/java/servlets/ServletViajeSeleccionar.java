package servlets;

import controller.ViajesController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jdgon
 */
@WebServlet("/ServletViajeSeleccionar")
public class ServletViajeSeleccionar extends HttpServlet {
      private static final long serialVersionUID = 1L;
    
    /**
     *@see HttpServlet#HttpServlet() 
     */
    
    public ServletViajeSeleccionar() {
        super();
        //TODO Auto-generated constructor stub
    }



    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)  
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        ViajesController servicio = new ViajesController();
        
        String ruta = request.getParameter("ruta");
        String username = request.getParameter("username");
        
        String servicioStr = servicio.seleccionar(ruta, username);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(servicioStr);
        out.flush();
        out.close();
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

 }