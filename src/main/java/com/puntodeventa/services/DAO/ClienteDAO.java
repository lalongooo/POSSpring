package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Cliente;
import com.puntodeventa.global.Util.LogHelper;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDAO {

    static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    private Session session;
    private Transaction tx;
    private LogHelper objLog = new LogHelper("ClienteDAO");

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

    //Metodo guarda CLIENTE
    public int saveCliente(Cliente cliente) {
        int id_Cliente;
        try {
            this.iniciaOperacion();
            id_Cliente = (int) session.save(cliente);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id_Cliente;
    }

    /**
     * Actualiza los datos de la tabla CLIENTE
     */
    public void updateCliente(Cliente cliente) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(cliente);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la tabla CLIENTE
     */
    public void deleteCliente(Cliente cliente) {
        try {
            this.iniciaOperacion();
            session.delete(cliente);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Método que devuelve un CLIENTE
     */
    public Cliente selectCliente(BigInteger idCliente) {
        Cliente cliente = null;
        try {
            this.iniciaOperacion();
            cliente = (Cliente) session.get(Cliente.class, idCliente);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return cliente;
    }

    public List<Cliente> listCliente() {
        List<Cliente> listCliente = null;
        try {
            this.iniciaOperacion();
            final Query sql = session.createQuery("from Cliente");
            listCliente = sql.list();
        } finally {
            session.close();
        }
        return listCliente;
    }
}