package com.puntodeventa.global.Util.Extended;

import com.puntodeventa.global.Util.TextLimiter;
import javax.swing.JPasswordField;

/**
 *
 * @author jehernandez
 */
public class JPasswordFieldExtended extends JPasswordField {

    public void setMaxLength(int maxlength) {
        super.setDocument(new TextLimiter(maxlength));
    }
}
