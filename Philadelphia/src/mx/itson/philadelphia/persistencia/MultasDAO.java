/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.philadelphia.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Conductor;
import mx.itson.philadelphia.entidades.Multa;
import mx.itson.philadelphia.entidades.Oficial;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ricardogarcia
 */
public class MultasDAO {
 public static List<Multa> obtenerTodos() {
        List<Multa> multas = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Multa> criteriaQuery = session.getCriteriaBuilder().createQuery(Multa.class);
            criteriaQuery.from(Multa.class);
            multas = session.createQuery(criteriaQuery).getResultList();
            
        } catch(HibernateException ex) {
            System.err.println("Ocurrio un error:" + ex.getMessage());
        }
        return multas;
    }
 
 public static boolean guardar(String folio, String motivo, String fecha, Oficial o, Conductor c) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Multa m = new Multa();
            m.setFolio(folio);
            m.setMotivo(motivo);
            m.setFecha(fecha);
            m.setConductor(c);
            m.setOficial(o);

            
            session.save(m);
            
            session.getTransaction().commit();
            resultado = m.getId() != 0 ;
        } catch ( HibernateException ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
 
 public static Multa obtenerbyId(int id) {
        Multa multa = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            multa = session.get(Multa.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un errro: " + ex.getMessage());
        }
        return multa;

    }

    public static boolean editar(int id, String folio, String motivo, String fechaAlta, Conductor c, Oficial o) {
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Multa multa = obtenerbyId(id);
            if (multa != null) {
                multa.setFolio(folio);
                multa.setMotivo(motivo);
                multa.setFecha(fechaAlta);
                multa.setConductor(c);
                multa.setOficial(o);

                session.saveOrUpdate(multa);
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un errro: " + ex.getMessage());
        }
        return resultado;
    }
}
