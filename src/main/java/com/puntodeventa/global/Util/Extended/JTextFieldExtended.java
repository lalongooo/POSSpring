package com.puntodeventa.global.Util.Extended;

import com.puntodeventa.global.Util.TextLimiter;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 * @author jehernandez
 */
public class JTextFieldExtended extends JTextField implements FocusListener, KeyListener {

    private boolean required = false;
    private String defaultText;

    public JTextFieldExtended(String defaultText, boolean required) {
        super(defaultText);
        this.defaultText = defaultText;
        this.required = required;

        super.setForeground(Color.GRAY);
        super.addFocusListener(this);
        super.addKeyListener(this);
    }

    public JTextFieldExtended() {
        this.defaultText = "";
        super.setForeground(Color.GRAY);
        super.addFocusListener(this);
        super.addKeyListener(this);
    }

    public void setDefaultText(String defaultText) {
        super.setForeground(Color.GRAY);
        super.setText(defaultText);
        this.defaultText = defaultText;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setMaxLength(int maxlength) {
        super.setDocument(new TextLimiter(maxlength));
    }

    @Override
    public String getText() {
        String typed = super.getText();
        return typed.equals(defaultText) ? "" : typed;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText(defaultText);
            super.setForeground(Color.GRAY);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.setForeground(Color.BLACK);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (super.getText().equals(defaultText)) {
            super.setForeground(Color.GRAY);
        }
    }
}
