/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.UsuarioDAO;
import java.util.List;

/**
 *
 * @author USER
 */
public class UsuarioLogic {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    LogHelper objLog = new LogHelper("UsuarioLogic");

    public Usuario getUsuario(String user, String pwd) {
        Usuario usuario;

        usuario = usuarioDAO.selectUsuario(111);

        return usuario;
    }

    public Usuario logonUsuario(String user, String pwd) {
        Usuario usuario = null;
        try {
            List<Usuario> usuarios = usuarioDAO.logonUsuario(user, pwd);

            if (usuarios.size() > 0) {
                usuario = usuarios.get(0);
            }

        } catch (Exception e) {
            objLog.Log(e.getMessage());
        }
        return usuario;
    }
}