/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.mvc.Views.jfrmVenta;

/**
 *
 * @author USER
 */
public class StepsController {

    public static void GoVenta() {
        jfrmVenta jfrmVenta = new jfrmVenta();
        jfrmVenta.setVisible(true);
    }
}
