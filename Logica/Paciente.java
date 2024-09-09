package Logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Persona {
    
    //private int idPaciente;
    private boolean tieneObraSocial;
    private String tipoSangre;
    
    @OneToMany(mappedBy = "paciente")
     private List<Turno> turnos;
     
     @OneToOne
     private Responsable responsable;

    public Paciente() {
    }
     
     

    public Paciente(boolean tieneObraSocial, String tipoSangre, List<Turno> turnos, Responsable responsable, int id, int dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.tieneObraSocial = tieneObraSocial;
        this.tipoSangre = tipoSangre;
        this.turnos = turnos;
        this.responsable = responsable;
    }


    public boolean isTieneObraSocial() {
        return tieneObraSocial;
    }

    public void setTieneObraSocial(boolean tieneObraSocial) {
        this.tieneObraSocial = tieneObraSocial;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    
     
     
     
     

    
    
}
