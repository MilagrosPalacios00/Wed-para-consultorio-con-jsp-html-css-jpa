
package servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
    Controladora controladora = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario"); 
        String contrasenia = request.getParameter("contrasenia"); 
        
        boolean validacion = false;
        
         validacion = controladora.validarIngreso(usuario , contrasenia);
        
        if (validacion == true){
            HttpSession miSesion = request.getSession(true);
            miSesion.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        
        }
        else { 
            
         response.sendRedirect("loginError.jsp");

            
        
        }
        

    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
