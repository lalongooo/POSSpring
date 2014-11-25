package com.puntodeventa.global.Util;

import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.Constants.Command;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author USER
 */
public class Util {

    private static LogHelper objLog = new LogHelper("Util");

    /**
     * Devuelve una cadena con el formato siguiente. [nombre del día] [día del
     * mes] [mes] [año] [hora]. Por ejemplo: lunes 28 enero 2013 12:01
     *
     * @param date La fecha a formatear
     * @return Una cadena con el formato especificado anteriormente. En caso de
     * excepción se devuelve una cadena vacía.
     */
    public static String formatDate(Date date) {
        String returnValue;

        try {
            returnValue = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(date);
        } catch (Exception e) {
            objLog.Log(e.getMessage());
            returnValue = "";
        }

        return returnValue;

    }

    /**
     * Da formato de número a una cantidad expresada en moneda
     *
     * @param value el valor a formatear
     * @return Un valor double.
     */
    public static double formatMoneyToDouble(String value) {
        double returnValue = 0;
        try {
            NumberFormat format = NumberFormat.getNumberInstance();
            Number number = format.parse(value);
            returnValue = number.doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnValue;
    }

    /**
     * Da formato de moneda a una cantidad cualquiera válida.
     *
     * @param value el valor a formatear
     * @return Una cadena formateada desde un valor de tipo Double a tipo Moneda
     */
    public static String formatDoubleValueToMoney(Double value) {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(value);
        return moneyString;
    }

    /**
     * Válida el efectivo capturado en Venta. Se soportan 2 decimales (el número
     * de decimales se consulta por parámetro) .
     *
     * @param value el valor a comprobar si una cantidad válida
     * @return True si la cantidad es válida, de lo contrario False
     */
    public static boolean isValidCashValue(String value) {

        boolean returnValue;
        double cash;

        try {
            cash = (Double) Double.parseDouble(value);
            returnValue = true;
        } catch (NumberFormatException nfe) {
            return false;
        }

        String strCash = String.valueOf(cash);
        if (strCash.contains(".")) {
            String decimalPart = strCash.substring(strCash.indexOf(".") + 1, strCash.length());
            int decimalValuesSupported = Integer.parseInt(ParamHelper.getParam("decimalPositionsSupported").toString());
            if (decimalPart.length() > decimalValuesSupported) {
                returnValue = false;
            }
        }

        return returnValue;
    }

    /**
     * Válida que el efectivo capturado no sobrepase lo máximo permitido.
     *
     * @param value el valor a comprobar
     * @return True si la cantidad no sobrepasa el máximo permitido, de lo
     * contrario False
     */
    public static boolean isCashExceeded(String value) {

        boolean returnValue = false;

        double cash = (Double) Double.parseDouble(value);
        double maxCashSupported = Double.parseDouble(ParamHelper.getParam("system.cashmax").toString());

        if (cash <= maxCashSupported) {
            returnValue = true;
        }

        return returnValue;
    }

    /**
     * Valida que num sea un número válido
     *
     * @param num el valor a comprobar si es un número válido
     * @return True si el valor es numérico, de lo contrario False
     */
    public static boolean isNumeric(String val) {

        boolean returnValue = false;

        try {

            for (int i = 0; i < val.length(); i++) {
                Integer.parseInt(val.charAt(i) + "");
                returnValue = true;
            }

        } catch (NumberFormatException nfe) {
            returnValue = false;
        } catch (Exception ex) {
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Obtiene la fecha actual
     *
     * @return La fecha actual en el sistema.
     */
    public static Date getDate() {
        java.util.Date date = new java.util.Date();
        return date;
    }

    public static Timestamp getDate_() {
        java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }

    /**
     * Determina si se agregarán productos con el símbolo de multiplicación
     *
     * @return La fecha actual en el sistema.
     */
    public static boolean isMultiplicationCommand(String value) {
        boolean returnValue = false;
        try {
            String values[] = value.split(Command.MULTIPLICATION_REGEX);

            if (values.length == 2) {
                Long.parseLong(values[0]);
                Long.parseLong(values[1]);
                returnValue = true;
            }

        } catch (NumberFormatException nfe) {
            returnValue = false;
        }

        return returnValue;
    }

    /**
     * Valida la cantidad ingresada en Venta. Se consulta por parámetro la
     * cantidad maxima de productos váildos a agregar a la compra
     *
     * @param num la cantidad que será agregada a la compra en formato String.
     * @return True si la cantidad y el formato son correctos, False si existe
     * un error en el formato de la cantidad capturada o la cantidad sobre pasa
     * lo permitido.
     */
    public static boolean isValidQty(String num) {
        int qty = 0;
        int maximItems = 0;
        boolean returnValue = false;

        try {
            qty = Integer.parseInt(num);
            maximItems = Integer.parseInt(ParamHelper.getParam("system.maxProducts").toString());
        } catch (NumberFormatException ex) {
            returnValue = false;
        }

        if (qty > 0 && qty <= maximItems) {
            returnValue = true;
        }

        return returnValue;
    }

    /**
     * Obtiene el usuario desde el archivo generado al loguearse un usuario al
     * sistema.
     *
     * @return El objeto de tipo Usuario que corresponde al usuario logueado
     * inicialmente, devuelve null por cualquier error.
     */
    public static Usuario getCurrentUser() {
        Usuario user;
        try {
            String fileName = ParamHelper.getParam("usr_srlzd_fl_nm").toString();

            try (ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
                user = (Usuario) input.readObject();
            }

        } catch (ClassNotFoundException | IOException ex) {
            user = null;
        }

        return user;
    }

    /**
     * Obtiene la información de la sesión actual.
     *
     * @return El objeto Sesion con la información de la misma.
     */
    public static Sesion getCurrentSesion() {
        Sesion sesion;

        try {
            String fileName = ParamHelper.getParam("ssn_srlzd_fl_nm").toString();

            try (ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
                sesion = (Sesion) input.readObject();
            }

        } catch (ClassNotFoundException | IOException ex) {
            sesion = null;
        }

        return sesion;
    }

    /**
     * Guarda a un archivo el objeto Usuario, que corresponde al usuario que
     * inicia la sesión en el sistema.
     *
     * @param user El objeto de tipo Usuario
     * @return True si el Usuario fue guardado correctamente, False si hubo
     * algún error.
     */
    public static boolean serializeUser(Usuario user) {
        boolean returnValue;

        try {
            String fileName = ParamHelper.getParam("usr_srlzd_fl_nm").toString();

            try (ObjectOutput output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {

                output.writeObject(user);
                returnValue = true;
            }
        } catch (IOException ex) {
            returnValue = false;
            System.out.println(ex.getMessage());
        }
        return returnValue;
    }

    /**
     * Guarda a un archivo el objeto Sesión, que corresponde a la sesión
     * iniciada en el sistema.
     *
     * @param sesion El objeto de tipo Sesion
     * @return True si la Sesion fue guardado correctamente, False si hubo algún
     * error.
     */
    public static boolean serializeSession(Sesion sesion) {
        boolean returnValue;

        try {
            String fileName = ParamHelper.getParam("ssn_srlzd_fl_nm").toString();

            try (ObjectOutput output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {

                output.writeObject(sesion);
                returnValue = true;
            }
        } catch (IOException ex) {
            returnValue = false;
            System.out.println(ex.getMessage());
        }
        return returnValue;
    }
}