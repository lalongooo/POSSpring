package com.puntodeventa.global.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jorge Hernàndez
 */
@Entity
@Table(name = "Venta_detalle")
public class VentaDetalle implements Serializable {

    @ManyToOne
    private Venta venta;
    
    @Column(name = "ID_PRODUCT")
    private String productCode;
    
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "SUBTOTAL")
    private double subtotal;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private long id;

    public VentaDetalle() {
    }

    public VentaDetalle(Venta venta, String productCode, int cantidad, double subtotal, long id) {
        this.venta = venta;
        this.productCode = productCode;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}