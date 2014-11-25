package com.puntodeventa.global.Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextLimiter extends PlainDocument {

    private Integer limit;

    public TextLimiter(Integer limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        if (limit == null || limit < 1 || ((getLength() + str.length()) <= limit)) {
            super.insertString(offs, str, a);
        } else if ((getLength() + str.length()) > limit) {
            String insertsub = str.substring(0, (limit - getLength()));
            super.insertString(offs, insertsub, a);
        }
    }
}