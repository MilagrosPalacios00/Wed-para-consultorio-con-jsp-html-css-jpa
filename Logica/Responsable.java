package Logica;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Responsable extends Persona {
    
    //private int idRespnsable;
    private String tipoResponsable;

    public Responsable() {
    }

    public Responsable(String tipoResponsable, int id, int dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.tipoResponsable = tipoResponsable;
    }

   

  /*  public int getIdRespnsable() {
        return idRespnsable;
    }

    public void setIdRespnsable(int idRespnsable) {
        this.idRespnsable = idRespnsable;
    }*/

    public String getTipoResponsable() {
        return tipoResponsable;
    }

    public void setTipoResponsable(String tipoResponsable) {
        this.tipoResponsable = tipoResponsable;
    }
    
    
    
    
    
    
    
    
}
