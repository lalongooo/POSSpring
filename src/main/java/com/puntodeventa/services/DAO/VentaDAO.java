package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.report.viewer.VentaProduct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class VentaDAO {

    ValidacionForms vali = new ValidacionForms();
    LogHelper objLog = new LogHelper("VentaDAO");
    private Session session;
    private Transaction tx;
    private static String query = "";

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

    //Metodo guarda venta
    public int saveVenta(Venta venta) {
        int idFolio = 0;
        try {
            this.iniciaOperacion();
            idFolio = Integer.parseInt(session.save(venta).toString());
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return idFolio;
    }

    /**
     * Actualiza los datos de la tabla Ventas
     */
    public void updateVenta(Venta venta) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(venta);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Ventas
     */
    public void deleteVenta(Venta venta) {
        try {
            this.iniciaOperacion();
            session.delete(venta);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Método que devuelve un objeto Venta
     */
    public Venta selectVenta(int idVenta) {
        Venta venta = null;
        try {
            this.iniciaOperacion();
            venta = (Venta) session.get(Venta.class, idVenta);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return venta;
    }
    

    public List<Venta> listVenta() {
        List<Venta> listVenta = null;

        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(query).addEntity(Venta.class);
            listVenta = sql.list();
        } finally {
        }
        return listVenta;
    }

    public double getTotalUserTurn() {

        double totalUserTurn = 0;
        List ventas = null;

        try {
            Sesion sesion = Util.getCurrentSesion();
            Usuario user = Util.getCurrentUser();

            this.iniciaOperacion();
            ventas = session
                    .createCriteria(Venta.class)
                    .add(Restrictions.between("fecha", sesion.getStartDate(), sesion.getEndDate()))
                    .add(Restrictions.eq("usuario", user))
                    .list();
            this.tx.commit();

        } catch (HibernateException hibernateException) {
            objLog.Log(hibernateException.getMessage());
        } catch (Exception ex) {
            objLog.Log(ex.getMessage());
        }

        if (!ventas.isEmpty()) {

            for (Object v : ventas) {
                Venta venta = (Venta) v;
                totalUserTurn += venta.getTotal();
            }


        }

        return totalUserTurn;
    }

    public double getTotalUserForCashCount() {

        double totalUserTurn = 0;
        List ventas = null;

        try {
            Sesion sesion = Util.getCurrentSesion();
            Usuario user = Util.getCurrentUser();

            this.iniciaOperacion();
            ventas = session
                    .createCriteria(Venta.class)
                    .add(Restrictions.gt("fecha", sesion.getStartDate()))
                    .add(Restrictions.eq("usuario", user))
                    .list();
            this.tx.commit();

        } catch (HibernateException hibernateException) {
            objLog.Log(hibernateException.getMessage());
        } catch (Exception ex) {
            objLog.Log(ex.getMessage());
        }

        if (!ventas.isEmpty()) {

            for (Object v : ventas) {
                Venta venta = (Venta) v;
                totalUserTurn += venta.getTotal();
            }


        }

        return totalUserTurn;
    }

    public List<VentaProduct> getVentaId(String id_folio) {
        List<VentaProduct> listVenta = null;
        String qry = " select  "
                + "A.ID_FOLIO,  "
                + "to_char(a.FECHA,'dd-MM-yyyy hh:mi:ss') FECHA,  "
                + "A.USUARIO_ID_USUARIO,  "
                + "d.Nombre usuario,  "
                + "B.ID_PRODUCT,  "
                + "C.PRODUCT PRODUCTO,  "
                + "C.DESCRIPCION,  "
                + "C.P_VENTA, "
                + "sum(B.CANTIDAD) CANTIDAD,  "
                + "sum(B.SUBTOTAL) SUBTOTAL, "
                + "A.CANTIDAD totCantidad, "
                + "A.TOTAL      "
                + "from ventas a, venta_detalle b, product c, vt_usuarios d  "
                + "where a.id_folio = b.venta_id_folio     "
                + "and C.ID_PRODUCT = B.ID_PRODUCT     "
                + "and A.USUARIO_ID_USUARIO = D.ID_USUARIO  "
                + "AND A.ID_FOLIO = '" + id_folio + "' "
                + "GROUP BY A.ID_FOLIO,  "
                + "to_char(a.FECHA,'dd-MM-yyyy hh:mi:ss'),  "
                + "A.USUARIO_ID_USUARIO,  "
                + "d.Nombre,  "
                + "B.ID_PRODUCT,  "
                + "C.PRODUCT,  "
                + "C.DESCRIPCION,  "
                + "C.P_VENTA,A.CANTIDAD, "
                + "A.TOTAL "
                + "ORDER BY A.ID_FOLIO ";
        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(qry);
            listVenta = getRecordVentaProduct(sql.list());
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return listVenta;
    }

    private List<VentaProduct> getRecordVentaProduct(List list) {
        List<VentaProduct> nlist = new ArrayList<VentaProduct>();
        for (int i = 0; i < list.size(); i++) {
            Object[] item = (Object[]) list.get(i);
            VentaProduct v = new VentaProduct();
            v.setId_folio(new BigInteger(item[0].toString()));
            v.setFecha(item[1].toString());
            v.setId_usuario(new BigInteger(item[2].toString()));
            v.setUsuario(item[3].toString());
            v.setId_product(item[4].toString());
            v.setProducto(item[5].toString());
            v.setDescripcion(item[6].toString());
            v.setP_venta(Double.parseDouble(item[7].toString()));
            v.setCantidad(Integer.parseInt(item[8].toString()));
            v.setSubtotal(Double.parseDouble(item[9].toString()));
            v.setTotCantidad(Integer.parseInt(item[10].toString()));
            v.setTotal(Double.parseDouble(item[11].toString()));
            nlist.add(v);
        }
        return nlist;
    }
    
    public int getLastTicketNumber() {
        this.iniciaOperacion();
        return (int) session.createCriteria(Venta.class)
                .setProjection(Projections.max("idFolio")).uniqueResult();        
    }

//    public int getTicketByNumber() {
//        return ventaDAO.getTotalUserForCashCount();
//    }
}