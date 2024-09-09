package Logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class Secretario extends Persona {
    
   // private int idSecretario;
    private String sector;
    @OneToOne
    private Usuario usuario;

    public Secretario() {
    }

    public Secretario(String sector, Usuario usuario, int id, int dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.sector = sector;
        this.usuario = usuario;
    }

   /* public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }*/

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
