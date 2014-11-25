package com.puntodeventa.global.Util;

public class JComboBoxItem {

    private String value;
    private String label;

    public JComboBoxItem(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}