
package servlets;

import Logica.Controladora;
import Logica.Turno;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {
    
        Controladora controladora = new Controladora();


  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         List<Turno> listaTurnos = controladora.getTurnos();
               
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaTurnos", listaTurnos);
        
        response.sendRedirect("verTurnos.jsp");
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
