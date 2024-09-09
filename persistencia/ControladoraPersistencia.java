
package persistencia;

import Logica.Horario;
import Logica.Odontologo;
import Logica.Turno;
import Logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    HorarioJpaController horaJpa = new HorarioJpaController();
    OdontologoJpaController odontoJpa = new OdontologoJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    
  

    public void crearUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);    
    }

    public List<Usuario> getUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void eliminarUsu(int idUsu) {
        try {
            usuarioJpa.destroy(idUsu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Usuario traerUsuario(int idUsu) {
        return usuarioJpa.findUsuario(idUsu);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuarioJpa.edit(usu); 
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
      public List<Odontologo> getOdontologos (){
          return odontoJpa.findOdontologoEntities();
      }

    public Odontologo traerOdontologo(int idOdonto) {
       return odontoJpa.findOdontologo(idOdonto);
    }

    public List<Horario> getHorariosDisponibles() {
        return  horaJpa.findHorarioEntities();
    }

    public void guardarTurno(Turno turno) {
        turnoJpa.create(turno);
    }

    public List<Turno> getTurnos() {
       return turnoJpa.findTurnoEntities();
    }
      
      

      
    }
     
    



    



    

    
    
    
    
    
    
    

