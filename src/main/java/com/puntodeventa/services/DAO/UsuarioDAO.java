package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.ValidacionForms;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class UsuarioDAO {

    ValidacionForms vali = new ValidacionForms();
    LogHelper objLog = new LogHelper("UsuarioDAO");
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

    //Metodo Guarda Usuarioo
    public int saveUsuario(Usuario usuario) {
        int id_usuario = 0;
        try {
            this.iniciaOperacion();
            id_usuario = Integer.parseInt(session.save(usuario).toString());
            tx.commit();
            vali.msjInfo(null, "Registro guardado correctamente...");
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id_usuario;
    }

    /**
     * Actualiza los datos de la tabla Usuario
     */
    public void updateUsuario(Usuario usuario) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(usuario);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Usuario
     */
    public void deleteUsuario(Usuario usuario) {
        try {
            this.iniciaOperacion();
            session.delete(usuario);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un objeto de tipo Usuario
     */
    public Usuario selectUsuario(int idUsuario) {
        Usuario usuario = null;
        try {
            this.iniciaOperacion();
            usuario = (Usuario) session.get(Usuario.class, idUsuario);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return usuario;
    }
    private static String query = "";

    public List<Usuario> listUsuario() {
        List<Usuario> listUsuario = null;

        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(query).addEntity(Usuario.class);
            listUsuario = sql.list();
        } finally {
        }
        return listUsuario;
    }

    public List<Usuario> logonUsuario(String user, String pwd) {

        List<Usuario> usuario = null;
        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(
                    "SELECT * FROM VT_USUARIOS"
                    + " WHERE  CVE_USUARIO = '" + user + "'"
                    + " AND CONTRASENA = '" + pwd + "'").addEntity(Usuario.class);
            usuario = sql.list();

        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return usuario;
    }
}