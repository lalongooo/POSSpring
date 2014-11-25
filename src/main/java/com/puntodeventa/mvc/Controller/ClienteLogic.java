package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Cliente;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.ClienteDAO;

public class ClienteLogic {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private LogHelper objLog = new LogHelper("ClienteLogic");

    public int saveCliente(Cliente cliente) {
        int idCliente = 0;
        try {
            idCliente = clienteDAO.saveCliente(cliente);
        } catch (Exception e) {
            objLog.Log(e.getMessage());
        }
        return idCliente;
    }
}