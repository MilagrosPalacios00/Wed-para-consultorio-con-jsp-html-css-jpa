/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Horario;
import Logica.Odontologo;
import Logica.Turno;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvReservarTurno", urlPatterns = {"/SvReservarTurno"})
public class SvReservarTurno extends HttpServlet {
    
     private Controladora controladora = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          int idOdonto = Integer.parseInt(request.getParameter("idOdonto"));

      
        Odontologo odontologo = controladora.traerOdontologo(idOdonto);   
        Horario horarioOdontologo = odontologo.getHorario();
        List<Horario> horariosDisponibles = controladora.generarHorariosDisponibles(horarioOdontologo.getHoraInicio() ,horarioOdontologo.getHoraFin());

         HttpSession miSesion = request.getSession();

       
        miSesion.setAttribute("odontologo", odontologo);
        miSesion.setAttribute("horariosDisponibles", horariosDisponibles);
        
        response.sendRedirect("reservarTurno.jsp");
            
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Obtener parámetros del formulario
    String idOdonto= request.getParameter("idOdonto");
    String idHorario= request.getParameter("idHorario");
    String fechaTurnoStr = request.getParameter("fechaTurno");
    String afeccion = request.getParameter("afeccion");
    String hora = request.getParameter("horario");
    
        System.out.println(idOdonto);
        System.out.println(idHorario);
        System.out.println(fechaTurnoStr);
        System.out.println(afeccion);
        System.out.println(hora);
        
    // Convertir la fecha de String a Date
   Date fechaTurno = null;
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         try {
       
             fechaTurno = sdf.parse(fechaTurnoStr);
         } catch (ParseException ex) {
             Logger.getLogger(SvReservarTurno.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    // Crear un nuevo objeto Turno
    Turno turno = new Turno();
    turno.setAfeccion(afeccion);
    turno.setFechaTurno(fechaTurno);
    turno.setHoraTurno(idHorario); 
  
    // Llamar al método de la controladora para guardar el turno
    controladora.guardarTurno(turno);

    // Redirigir a una página de confirmación
    response.sendRedirect("confirmacion.jsp");
}


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
