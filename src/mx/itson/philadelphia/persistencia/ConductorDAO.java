
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Conductor;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class ConductorDAO {
    
    public static List<Conductor> obtenerTodos() {
        List<Conductor> conductores = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Conductor> criteriaQuery = session.getCriteriaBuilder().createQuery(Conductor.class);
            criteriaQuery.from(Conductor.class);
            conductores = session.createQuery(criteriaQuery).getResultList();
            
        } catch(HibernateException ex) {
            System.err.println("Ocurrio un error:" + ex.getMessage());
        }
        return conductores;
    }
    
    public static boolean guardar(String nombre, String numeroLicencia, String fechaAlta) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Conductor c = new Conductor();
            c.setNombre(nombre);
            c.setNumeroLicencia(numeroLicencia);
            c.setFechaAlta(fechaAlta);
            
            session.save(c);
            
            session.getTransaction().commit();
            resultado = c.getId() != 0 ;
        } catch ( HibernateException ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
    
    public static Conductor obtenerbyId(int id) {
        Conductor conductor = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            conductor = session.get(Conductor.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return conductor;

    }
    
    
    public static boolean editar(int id, String nombre, String numeroLicencia, String fechaAlta) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Conductor conductor = obtenerbyId(id);
            if (conductor != null) {
                conductor.setNombre(nombre);
                conductor.setNumeroLicencia(numeroLicencia);
                conductor.setFechaAlta(fechaAlta);

                session.saveOrUpdate(conductor);
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
}
