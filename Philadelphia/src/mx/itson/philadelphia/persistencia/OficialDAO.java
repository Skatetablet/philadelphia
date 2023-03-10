/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Oficial;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;





public class OficialDAO {

    public static List<Oficial> obtenerTodos() {
        List<Oficial> oficiales = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Oficial> criteriaQuery = session.getCriteriaBuilder().createQuery(Oficial.class);
            criteriaQuery.from(Oficial.class);
            oficiales = session.createQuery(criteriaQuery).getResultList();

        } catch (Exception ex) {
            System.err.println("Ocurrio un errro: " + ex);
        }
        return oficiales;
    }
    
    public static boolean guardar(String nombre, String telefono) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Oficial o = new Oficial();
            o.setNombre(nombre);
            o.setTelefono(telefono);
            session.save(o);
            session.getTransaction().commit();

            resultado = o.getId() != 0;

        } catch (Exception ex) {
            System.err.println("Ocurrio un errro: " + ex);

        }
        return resultado;
    }
    
    public Oficial obtenerbyId(int id) {
        Oficial oficiales = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            oficiales = session.get(Oficial.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un errro: " + ex.getMessage());
        }
        return oficiales;

    }

}