package Logica;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import persistencia.ControladoraPersistencia;


public class Controladora {
    

    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia(); 
    

    public void crearUsuario(Usuario usuario) {     
        controlPersis.crearUsuario(usuario); 
    }

    public List<Usuario> getUsuarios() {
        return controlPersis.getUsuarios();
    }

    public void eliminarUsu(int idUsu) {
        controlPersis.eliminarUsu(idUsu);
        
    }

    public Usuario traerUsuario(int idUsu) {
       return  controlPersis.traerUsuario(idUsu);
        
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
        
    }

    public boolean validarIngreso(String usuario, String contrasenia) {
        
        List<Usuario> listaUsuarios = controlPersis.getUsuarios();
        
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsu().equals(usuario) && usu.getContraseña().equals(contrasenia)) {
                return true;
            }
        }     
        return false; 
    }
    
    public List<Odontologo> getOdontologos (){
        return controlPersis.getOdontologos();
    }

    public Odontologo traerOdontologo(int idOdonto) {
       return controlPersis.traerOdontologo(idOdonto);
    }

    public List<Horario> getHorariosDisponibles() {
        return controlPersis.getHorariosDisponibles();
    }
    
  public List<Horario> generarHorariosDisponibles(String horaInicioStr, String horaFinStr) {

       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

   
        LocalTime horaInicio = LocalTime.parse(horaInicioStr, formatter);
        LocalTime horaFin = LocalTime.parse(horaFinStr, formatter);

        List<Horario> horarios = new ArrayList<>();

        while (horaInicio.isBefore(horaFin)) {
            LocalTime finHorario = horaInicio.plusHours(1);
            if (finHorario.isAfter(horaFin)) {
                finHorario = horaFin; 
            }
            Horario nuevoHorario = new Horario();
            nuevoHorario.setHoraInicio(horaInicio.toString());  
            nuevoHorario.setHoraFin(finHorario.toString());
            horarios.add(nuevoHorario);
            horaInicio = finHorario; 
        }
        return horarios;
    }
  
  public void guardarTurno(Turno turno){
      controlPersis.guardarTurno(turno);
  }

    public List<Turno> getTurnos() {     
        return controlPersis.getTurnos();
    }

   

}
