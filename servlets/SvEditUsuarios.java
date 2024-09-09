package servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {
    
    
    Controladora controladora = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {           
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          int idUsu = Integer.parseInt(request.getParameter("idUsu"));
          
         Usuario usu = controladora.traerUsuario(idUsu);
         
          HttpSession miSesion = request.getSession();
          miSesion.setAttribute("usuEditar", usu);
        
         response.sendRedirect("editarUsuarios.jsp");
    
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         request.setCharacterEncoding("UTF-8");

        
        String nombre = request.getParameter("nomUsu");
        String contraseña = request.getParameter("contraseña");
        String rol = request.getParameter("rol");
        
        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        
        usu.setNombreUsu(nombre);
        usu.setContraseña(contraseña);
        usu.setRol(rol);
        
        controladora.editarUsuario(usu);
        
        response.sendRedirect("SvUsuarios");
        
        
        
        
        
        

        
          
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
