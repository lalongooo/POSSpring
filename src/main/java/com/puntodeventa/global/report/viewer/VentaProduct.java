/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import java.math.BigInteger;

/**
 *
 * @author Nato
 */
public class VentaProduct {    
    
    private BigInteger id_folio;
    private String fecha;    
    private BigInteger id_usuario;
    private String usuario;
    private String id_product;
    private String producto;
    private String descripcion;
    private Double p_venta;
    private int cantidad;
    private Double subtotal;
    private int totCantidad;
    private Double total;

    public VentaProduct() {
    }

    public VentaProduct(BigInteger id_folio, String fecha, BigInteger id_usuario, String usuario, String id_product, String producto, String descripcion, Double p_venta, int cantidad, Double subtotal, int totCantidad, Double total) {
        this.id_folio = id_folio;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.id_product = id_product;
        this.producto = producto;
        this.descripcion = descripcion;
        this.p_venta = p_venta;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.totCantidad = totCantidad;
        this.total = total;
    }
    

    /**
     * @return the id_folio
     */
    public BigInteger getId_folio() {
        return id_folio;
    }

    /**
     * @param id_folio the id_folio to set
     */
    public void setId_folio(BigInteger id_folio) {
        this.id_folio = id_folio;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the id_usuario
     */
    public BigInteger getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(BigInteger id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the id_product
     */
    public String getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the p_venta
     */
    public Double getP_venta() {
        return p_venta;
    }

    /**
     * @param p_venta the p_venta to set
     */
    public void setP_venta(Double p_venta) {
        this.p_venta = p_venta;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the totCantidad
     */
    public int getTotCantidad() {
        return totCantidad;
    }

    /**
     * @param totCantidad the totCantidad to set
     */
    public void setTotCantidad(int totCantidad) {
        this.totCantidad = totCantidad;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

        
}
