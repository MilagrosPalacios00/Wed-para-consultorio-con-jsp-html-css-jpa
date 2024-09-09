
package servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    Controladora controladora = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        List<Usuario> listaUsuarios = controladora.getUsuarios();
               
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios", listaUsuarios);
        
        response.sendRedirect("verUsuarios.jsp");
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            request.setCharacterEncoding("UTF-8");
        
            String nombreUsuario = request.getParameter("nomUsu");                    
            String contraseña = request.getParameter("contraseña");
            String rol = request.getParameter("rol");
            
         
            Usuario usuario = new Usuario ();
            
            usuario.setNombreUsu(nombreUsuario);
            usuario.setContraseña(contraseña);
            usuario.setRol(rol);
            
            controladora.crearUsuario(usuario);
            
            response.sendRedirect("index.jsp");
                       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
