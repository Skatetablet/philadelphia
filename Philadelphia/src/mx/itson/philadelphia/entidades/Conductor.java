
package mx.itson.philadelphia.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// import javax.persistence.Table;

@Entity

public class Conductor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombre;
    private String numeroLicencia;
    
    
    private String fechaAlta;
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }


    public String getFechaAlta() {
        return fechaAlta;
    }

    
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    public String toString() {
        return this.nombre;
    }
    
}
