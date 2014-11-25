package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.VentaDetalle;
import com.puntodeventa.global.Util.LogHelper;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class VentaDetalleDAO {

    LogHelper objLog = new LogHelper("VentaDetalleDAO");
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

    //Metodo guarda ventaDetalle
    public boolean saveVentaDetalle(VentaDetalle ventaDetalle) {
        boolean returnValue = false;
        try {
            this.iniciaOperacion();
            session.save(ventaDetalle);
            tx.commit();
            returnValue = true;
        } catch (HibernateException he) {
            returnValue = false;
            this.manejaException(he);
            objLog.Log(he.getMessage());
        } finally {
            session.close();
        }
        return returnValue;
    }

    /**
     * Actualiza los datos de la tabla VentaDetalles
     */
    public boolean updateVentaDetalle(VentaDetalle ventaDetalle) throws HibernateException {
        boolean returnValue = false;
        try {
            this.iniciaOperacion();
            session.update(ventaDetalle);
            tx.commit();
            returnValue = true;
        } catch (HibernateException he) {
            returnValue = false;
            this.manejaException(he);
            objLog.Log(he.getMessage());
        } finally {
            session.close();
        }

        return returnValue;
    }

    /**
     * Elimina registro de la Tabla VentaDetalles
     */
    public void deleteVentaDetalle(VentaDetalle ventaDetalle) {
        try {
            this.iniciaOperacion();
            session.delete(ventaDetalle);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un objeto VentaDetalle
     */
    public VentaDetalle selectVentaDetalle(int idVentaDetalle) {
        VentaDetalle ventaDetalle = null;
        try {
            this.iniciaOperacion();
            ventaDetalle = (VentaDetalle) session.get(VentaDetalle.class, ventaDetalle);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return ventaDetalle;
    }
    private static String query = "";

    public List<VentaDetalle> listVentaDetalle() {
        List<VentaDetalle> listVentaDetalle = null;

        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(query).addEntity(VentaDetalle.class);
            listVentaDetalle = sql.list();
        } finally {
        }
        return listVentaDetalle;
    }
}