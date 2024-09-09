
package servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "SvElimUsuarios", urlPatterns = {"/SvElimUsuarios"})
public class SvElimUsuarios extends HttpServlet {
    
    Controladora controladora = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int idUsu = Integer.parseInt(request.getParameter("idUsu"));
         
         controladora.eliminarUsu(idUsu);
         
         response.sendRedirect("SvUsuarios");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
