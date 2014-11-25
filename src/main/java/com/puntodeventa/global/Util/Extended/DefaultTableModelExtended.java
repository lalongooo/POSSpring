package com.puntodeventa.global.Util.Extended;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class DefaultTableModelExtended extends DefaultTableModel {

    public DefaultTableModelExtended() {
    }

    @Override
    public boolean isCellEditable(int row, int Column) {
        return false;
    }    
}
