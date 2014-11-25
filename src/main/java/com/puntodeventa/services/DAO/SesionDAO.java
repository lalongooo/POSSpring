package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.LogHelper;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jorge Eduardo Hernández
 */
public class SesionDAO {

    LogHelper objLog = new LogHelper("SesionDAO");
    private Session session;
    private Transaction tx;

    //Metodo: Inicializa la operacion para procesos en la base de datos
    private void iniciaOperacion() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
        } catch (HibernateException ex) {
            objLog.Log(ex.getMessage());
        }
    }

    // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
    private void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        objLog.Log(he.getMessage());
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos. Error: " + he.getMessage());
    }

    //Metodo guarda Sesion
    public int saveSesion(Sesion sesion) {
        int idSesion = 0;
        try {
            this.iniciaOperacion();
            idSesion = Integer.parseInt(session.save(sesion).toString());
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            objLog.Log(he.getMessage());
            throw he;
        } finally {
            session.close();
        }
        return idSesion;
    }

    /**
     * Actualiza los datos de la tabla Sesion
     */
    public void updateSesion(Sesion sesion) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(sesion);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Sesión
     */
    public void deleteSesion(Sesion sesion) {
        try {
            this.iniciaOperacion();
            session.delete(sesion);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un objeto Sesión
     */
    public Sesion selectSesion(int idSesion) {
        Sesion sesion = null;
        try {
            this.iniciaOperacion();
            sesion = (Sesion) session.get(Sesion.class, idSesion);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return sesion;
    }

    public ArrayList<Sesion> getPendingSessions(Usuario user) {

        ArrayList<Sesion> sessions = new ArrayList<>();

        try {

            this.iniciaOperacion();
            sessions = (ArrayList<Sesion>) session
                    .createCriteria(Sesion.class)
                    .add(Restrictions.isNull("endDate"))
                    .add(Restrictions.eq("active", Sesion.ACTIVE))
                    .add(Restrictions.eq("cutPending", Sesion.CUT_PENDING))
                    .add(Restrictions.eq("usuario", user))
                    .addOrder(Order.desc("startDate"))
                    .setMaxResults(1)
                    .list();
            this.tx.commit();
        } catch (HibernateException hibernateException) {
            objLog.Log(hibernateException.getMessage());
        }

        return sessions;
    }

    public List<Sesion> listSesion() {
        List<Sesion> listSesion = null;
        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery("SELECT * FROM Sesion ORDER BY 2").addEntity(Sesion.class);
            listSesion = sql.list();
        } finally {
            session.close();
        }
        return listSesion;
    }
}