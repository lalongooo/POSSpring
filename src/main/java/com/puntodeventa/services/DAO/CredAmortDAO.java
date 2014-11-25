package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.CredAmort;
import com.puntodeventa.global.Util.LogHelper;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CredAmortDAO {

    static final Logger LOG = Logger.getLogger(CredAmortDAO.class.getName());
    private Session session;
    private Transaction tx;
    private LogHelper objLog = new LogHelper("CredAmortDAO");

    //Metodo: Inicializa la operacion para procesos en la base de datos
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
    private void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        objLog.Log(he.getMessage());
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos. Error: " + he.getMessage());
    }

    //Metodo guarda CREDAMORT
    public int saveCredAmort(CredAmort amortizacion) {
        int id_CredAmort;
        try {
            this.iniciaOperacion();
            id_CredAmort = (int) session.save(amortizacion);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
        return id_CredAmort;
    }

    /**
     * Actualiza los datos de la tabla CREDAMORT
     */
    public void updateCredAmort(CredAmort amortizacion) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(amortizacion);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la tabla CREDAMORT
     */
    public void deleteCredAmort(CredAmort amortizacion) {
        try {
            this.iniciaOperacion();
            session.delete(amortizacion);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Método que devuelve un CREDAMORT
     */
    public CredAmort selectCredAmort(int idCredAmort) {
        CredAmort amortizacion = null;
        try {
            this.iniciaOperacion();
            amortizacion = (CredAmort) session.get(CredAmort.class, idCredAmort);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return amortizacion;
    }

    public List<CredAmort> listCredAmort() {
        List<CredAmort> listCredAmort = null;
        try {
            this.iniciaOperacion();
            final Query sql = session.createQuery("from CredAmort");
            listCredAmort = sql.list();
        } finally {
            session.close();
        }
        return listCredAmort;
    }
}