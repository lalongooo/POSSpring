package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Munic;
import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.global.Util.LogHelper;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MunicDAO {

    static final Logger LOG = Logger.getLogger(MunicDAO.class.getName());
    private Session session;
    private Transaction tx;
    private LogHelper objLog = new LogHelper("MunicDAO");

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

    //Metodo Guarda GRA_MUNIC
    public int saveMunic(Munic munic) {
        int id_munic;
        try {
            this.iniciaOperacion();
            id_munic = (int) session.save(munic);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id_munic;
    }

    /**
     * Actualiza los datos de la tabla GRA_MUNIC
     */
    public void updateMunic(Munic munic) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(munic);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la tabla GRA_MUNIC
     */
    public void deleteMunic(Munic munic) {
        try {
            this.iniciaOperacion();
            session.delete(munic);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Método que devuelve un Munic
     */
    public Munic selectMunic(int id_munic) {
        Munic munic = null;
        try {
            this.iniciaOperacion();
            munic = (Munic) session.get(Munic.class, id_munic);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return munic;
    }

    public List<Munic> listMunic() {
        List<Munic> listMunic = null;
        try {
            this.iniciaOperacion();
            final Query sql = session.createQuery("from Munic");
            listMunic = sql.list();
        } finally {
            session.close();
        }
        return listMunic;
    }
}