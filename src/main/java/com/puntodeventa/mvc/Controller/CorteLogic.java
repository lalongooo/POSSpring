/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.CorteDAO;

/**
 * @author Jorge Eduardo Hernández Hernández
 */
public class CorteLogic {

    private CorteDAO corteDAO = new CorteDAO();
    private LogHelper objLog = new LogHelper("CorteLogic");    
    
    public boolean processCut(double efvoInicial, double efvoCaja){
        boolean returnValue = false;
        try {
            returnValue = corteDAO.processCut(efvoInicial, efvoCaja);
        } catch (Exception e) {
            objLog.Log(e.getMessage());
        }
        return returnValue;
    }
}