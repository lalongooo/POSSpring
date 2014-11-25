package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.VentaDAO;

/**
 *
 * @author USER
 */
public class VentaLogic {

    VentaDAO ventaDAO = new VentaDAO();
    LogHelper objLog = new LogHelper("VentaLogic");

    public int saveVenta(Venta venta) {
        int idFolio = 0;
        try {
            idFolio = ventaDAO.saveVenta(venta);
        } catch (Exception e) {
            objLog.Log(e.getMessage());
        }
        return idFolio;
    }

    public double getTotalUserTurn() {
        return ventaDAO.getTotalUserTurn();
    }

    public double getTotalUserForCashCount() {
        return ventaDAO.getTotalUserForCashCount();
    }

    public int getLastTicketNumber() {
        return ventaDAO.getLastTicketNumber();
    }

    public Venta getVenta(int ticketNumber) {
        return ventaDAO.selectVenta(ticketNumber);
    }
}