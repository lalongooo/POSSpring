package com.puntodeventa.global.Util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class ValidacionForms {

    // Mensaje: Variables del tipo de mensaje
    static int
            INFO = JOptionPane.INFORMATION_MESSAGE,
            ERR = JOptionPane.ERROR_MESSAGE,
            WARN = JOptionPane.WARNING_MESSAGE,
            OPT = JOptionPane.YES_NO_OPTION,
            QUE = JOptionPane.QUESTION_MESSAGE;

    /**
     * Metodo: Obtiene la hora actual del equipo(sistema)
     *
     * @return Una cadena de texto que indica la hora actual en el formato
     * "hh:mm:ss"
     */
    public String horaActual() {
        Date hora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(hora);
    }

    /**
     * Valida la entrada de datos a numerico
     *
     * @param evt evento del tipo KeyEvent en el cual se suprmiran los
     * caracteres que no sean numéricos
     */
    public void soloNumeros(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_9)) {
            evt.consume(); //Ignora el evento de teclado
        }
    }

    /**
     * Valida la entrada de datos a alfabeto a-z , A-Z
     *
     * @param evt evento del tipo KeyEvent en el cual se aceptaran solo letras.
     */
    public void soloLetras(KeyEvent evt) {
        int k = (int) evt.getKeyChar();
        if (k > 47 && k < 58) {
            k = (int) evt.getKeyChar() + 1;
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }

    /**
     * Permite validar la longitud de la caja de texto
     *
     * @param jtxtName El objeto de tipo JTextField en el cual se validará la
     * longitud de caracteres capturados
     * @param tamanio Número de caracteres permitidos en el campo de texto
     * (parámetro jtxtName)
     * @param evt evento del tipo KeyEvent en el cual se aceptaran solo letras.
     */
    public void longitudCaga(JTextField jtxtName, int tamanio, KeyEvent evt) {
        int val = jtxtName.getText().length();
        int aux = tamanio - 1;
        if (val > aux) {
            evt.consume();
        }
    }

    /**
     * Elimina las filas de un JTable
     *
     * @param myTable El objeto de tipo JTable del que se eliminarán las filas
     */
    public void cleanTable(JTable myTable) {
        DefaultTableModel tableModel = (DefaultTableModel) myTable.getModel();
        int rows = myTable.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; rows--) {
                tableModel.removeRow(i);
            }
        }
    }

    /**
     * Ajusta el ancho de las columnas de un JTable
     *
     * @param jtxtName El objeto JTable
     */
    public void anchoColumTable(JTable myTabla) {
        // Asignamos ancho de columnas de un JTable
        int[] anchos = {5, 150, 10, 10, 10};
        for (int i = 0; i < myTabla.getColumnCount(); i++) {
            myTabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    /**
     * Elimina los elementos de la lista, excepto el primero
     *
     * @param myCombo A JComboBox component
     */
    public boolean cleanJCombo(JComboBox myCombo) {
        int itemCount = myCombo.getItemCount();
        for (int i = 1; i < itemCount; itemCount--) {
            myCombo.removeItemAt(i);
        }
        return true;
    }

    /**
     * Limpia el contenido de las cajas de texto contenidas en un JPanel
     *
     * @param myJPanel El objeto de tipo JPanel del que se limpiaran sus cajas
     * de texto (JTexfield)
     */
    public void cleanTextField(JPanel myJPanel) {
        Component[] componentes = myJPanel.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
        }
    }

    /**
     * Metodo que permite editar componentes JTextField de un JPanel
     */
    public void editTextFields(JPanel jpane, Boolean ban) {
        Component[] componentes = jpane.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setEditable(ban);
            }
        }
    }

    /**
     * Method: Pide Contrasenia de desbloquear usuario del systema Devuelve un
     * String
     */
    public String pidePassword() {
        JPasswordField pass = new JPasswordField();
        pass.requestFocus();
        JOptionPane.showMessageDialog(null, pass, "Password", INFO);
        pass.requestFocus();
        return pass.getText();
    }

    /**
     * Convierte de minusculas a mayusculas el contenido de un JtextFieldMinus
     *
     * @param jtxtName El objeto JTextField
     */
    public void convertMayus(JTextField jtxtName) {
        jtxtName.setText(jtxtName.getText().toUpperCase());
    }

    /**
     * Method: Muestra un Pane de mensaje de Informacion
     *
     * @params message
     */
    public void msjInfo(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(null, message, "Información", INFO);
    }

    /**
     * Method: Muestra un Pane de mensaje de error
     *
     * @param message
     */
    public void msjErr(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", ERR);
    }

    /**
     * Method: Muestra un mensaje de advertencia
     *
     * @params message
     */
    public void msjWarn(String message) {
        JOptionPane.showMessageDialog(null, message, "Advertencia", WARN);
    }

    /**
     * Mensaje de opcion/confirmacion Aceptar-Cancelar Devuelve cero(0) si la
     * opcion es Aceptar Devuelve dos(2) si la opcion es Cancelar
     */
    public int msjOption(String message, String title) {
        int op = JOptionPane.showConfirmDialog(null, message, title, OPT);
        return op;
    }

    /**
     * Muestra un Pane de tipo input.
     *
     * @param message Mensaje del cuadro de diálogo.
     * @param title Título que se muestra en el diálogo.
     * @return Devuelve el valor capturado en el campo mostrado en el diálogo
     */
    public String msjInput(String message, String title) {
        String op = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
        return op;
    }

    /**
     *
     */
    public boolean centerFrame(JInternalFrame myFrame) {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setLocation((pantalla.width - myFrame.getPreferredSize().width) / 2, (pantalla.height - myFrame.getPreferredSize().height) / 2);
        return true;
    }
}