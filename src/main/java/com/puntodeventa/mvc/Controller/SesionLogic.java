/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.services.DAO.SesionDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author USER
 */
public class SesionLogic {


    private SesionDAO sesionDAO = new SesionDAO();
    private LogHelper objLog = new LogHelper("SesionLogic");

    private boolean saveSesion(Sesion sesion) {
        boolean returnValue;
        int sessionId = 0;
        try {
            sessionId = sesionDAO.saveSesion(sesion);
            returnValue = true;
        } catch (Exception e) {
            this.objLog.Log(e.getMessage());
            returnValue = false;
        }

        if (returnValue && sessionId > 0) {
            returnValue = true;
        }
        return returnValue;
    }

    public boolean startSesion(Usuario user) {

        boolean returnValue;

        Sesion sesion = new Sesion();

        sesion.setActive(Sesion.ACTIVE);
        sesion.setCutPending(Sesion.CUT_PENDING);
        sesion.setStartDate(new Date());
        sesion.setUsuario(user);

        returnValue = this.saveSesion(sesion);
        Util.serializeSession(sesion);

        return returnValue;
    }

    public boolean endSesion() {

        boolean returnValue;

        try {
            Sesion sesion = Util.getCurrentSesion();
            sesion.setEndDate(new Date());
            sesion.setActive(Sesion.NOT_ACTIVE);
            sesion.setCutPending(Sesion.NOT_CUT_PENDING);
            sesionDAO.updateSesion(sesion);
            Util.serializeSession(sesion);

            returnValue = true;
        } catch (HibernateException hibernateException) {
            objLog.Log(hibernateException.getMessage());
            returnValue = false;
        }

        return returnValue;
    }

    public List<Sesion> listSesion() {
        return sesionDAO.listSesion();
    }

    public ArrayList<Sesion> getPendingSessions(Usuario user) {
        ArrayList<Sesion> sessions = null;
        
        try {
            sessions = sesionDAO.getPendingSessions(user);
        } catch (Exception e) {
            objLog.Log(e.getMessage());
        }
        
        return sessions;
    }
}