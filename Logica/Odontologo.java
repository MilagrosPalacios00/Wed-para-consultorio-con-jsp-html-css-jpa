package Logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona {
    
    //private int idOdontologo;
    private String especialidad;
    
    //Relacion one to many
    @OneToMany (mappedBy = "odonto")
     private List<Turno> turnos;
     
     //Relacion one to one
     @OneToOne
     private Usuario usuario;
     @OneToOne
     private Horario horario;
     

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> turnos, Usuario usuario, Horario horario, int id, int dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.especialidad = especialidad;
        this.turnos = turnos;
        this.usuario = usuario;
        this.horario = horario;
    }

   

  /*  public int getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }*/

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    
    
    
     
     
    
}
