package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Corte;
import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Enum.PrintType;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.printservice.POSPrintService;
import com.puntodeventa.global.report.viewer.printCorte;
import com.puntodeventa.mvc.Controller.VentaLogic;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.icepdf.core.exceptions.PDFSecurityException;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class CorteDAO {

    LogHelper objLog = new LogHelper("CorteDAO");
    static printCorte pCorte = new printCorte();
    private Session session;
    private Transaction tx;
    private List<Corte> listCorte = new ArrayList<>();
    byte[] pdfBuffer = null;

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

    //Metodo guarda corte
    public int saveCorte(Corte corte) {
        int idFolio = 0;
        try {
            this.iniciaOperacion();
            idFolio = Integer.parseInt(session.save(corte).toString());
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
    public void updateCorte(Corte corte) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(corte);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Corte
     */
    public void deleteCorte(Corte corte) {
        try {
            this.iniciaOperacion();
            session.delete(corte);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un objeto Corte
     */
    public Corte selectCorte(int idCorte) {
        Corte corte = null;
        try {
            this.iniciaOperacion();
            corte = (Corte) session.get(Corte.class, corte);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return corte;
    }

    public boolean processCut(double efvoInicial, double efvoCaja) throws PDFSecurityException {

        boolean returnValue = false;
        Corte corte = new Corte();
        List ventas = null;
        Usuario user = null;
        Sesion sesion = null;

        try {
            sesion = Util.getCurrentSesion();
            user = Util.getCurrentUser();
        } catch (Exception e) {
            objLog.Log("Cuse: Error while getting current Session or User" + e.getMessage());
        }

        try {

            if (user != null && sesion != null) {
                this.iniciaOperacion();
                ventas = session.createCriteria(Venta.class).add(Restrictions.between("fecha", sesion.getStartDate(), sesion.getEndDate())).add(Restrictions.eq("usuario", user)).list();
                this.tx.commit();
            }

        } catch (HibernateException hibernateException) {
            objLog.Log("Cause: Error while getting the Ventas list from DB. " + hibernateException.getMessage());
        } catch (Exception ex) {
            objLog.Log(ex.getMessage());
        }

        try {

            double total = 0;
            try {
                VentaLogic vtaLgc = new VentaLogic();
                total = vtaLgc.getTotalUserTurn();
            } catch (Exception e) {
                objLog.Log("Error while getting total of the current user from DB. " + e.getMessage());
            }

            if (ventas != null) {

                int elements = ventas.size();
                Venta firstElm, secElem;

                if (!ventas.isEmpty()) {
                    firstElm = (Venta) ventas.get(0);
                    secElem = (Venta) ventas.get(ventas.size() - 1);

                    corte.setEfvoCaja(efvoCaja);
                    corte.setEfvoInicial(efvoInicial);
                    corte.setFecha(new Date());
                    corte.setId_usuario(user);
                    corte.setNumero_de_ventas(elements);
//                    corte.setTotal_preciocompra(orders);
                    corte.setTotal_precioventa(total);
                    corte.setVentafolio_from(firstElm.getIdFolio());
                    corte.setVentafolio_to(secElem.getIdFolio());
                    corte.setTotal_corte(total);
                }
            }
            int id_folio = 0;
            try {

                id_folio = this.saveCorte(corte);
            } catch (Exception e) {
                objLog.Log("Error while savinging Corte. " + e.getMessage());
            }

            try {
                pdfBuffer = pCorte.printCortepdfBuffer(corte, user);
            } catch (Exception e) {
                objLog.Log("Error while exportTopdf in disco. " + e.getMessage());
            }
            try {
                if (pdfBuffer != null){
                    POSPrintService.printArrayPdf(pdfBuffer);
                }else{
                    objLog.Log("pdfBuffer is null");
                }
            } catch (Exception ex) {
                objLog.Log("Error while printing Corte. " + ex.getMessage());
            }

        } catch (Exception e) {
            objLog.Log("Error while processing Corte. " + e.getMessage());
        }

        return returnValue;
    }
}