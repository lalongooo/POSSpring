/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Munic;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.MunicDAO;
import java.util.List;

/**
 * @author Jorge Eduardo Hernández Hernández
 */
public class MunicLogic {

    private MunicDAO municDAO = new MunicDAO();
    private LogHelper objLog = new LogHelper("MunicLogic");

    public List<Munic> getMunics() {
        return municDAO.listMunic();
    }
}