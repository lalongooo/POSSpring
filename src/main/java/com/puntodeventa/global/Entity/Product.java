/*
 * Nombre del paquete o directorio donde se encuentra esta clase
 * Bean Product
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Fortunato Hdez Hdez
 */
//Indicamos que esta clase es una entidad
@Entity
//Inicializamos el nombre de la tabla, tabla de la base de datos
@Table(name = "Product")
public class Product implements Serializable {
    // Declaramos los campos o estructura de la tabla

    @Id
    @Column(name = "id_product")
    private String id_product;
    @Column(name = "product")
    private String product;
    @Column(name = "Descripcion")
    private String Descripcion;
    @Column(name = "P_Compra")
    private double p_compra;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha_registro")
    private String fecha;
    @Column(name = "id_Negocio")
    private int id_Negocio;
    @Column(name = "Codigo_Barras")
    private BigInteger codigo_barras;
    @Column(name = "p_venta")
    private double p_venta;
    @Column(name = "activo")
    private int activo;
    @Column(name = "fecha_actualiza")
    private String fecha_actualiza;
    @Column(name = "minimo")
    private String minimo;
    @Column(name = "maximo")
    private String maximo;
    @Column(name = "id_category")
    private String id_category;

    public Product(String id_product, String product, String Descripcion, double p_compra, int cantidad, String fecha, int id_Negocio, BigInteger codigo_barras, double p_venta, int activo, String fecha_actualiza, String minimo, String maximo, String id_category) {
        this.id_product = id_product;
        this.product = product;
        this.Descripcion = Descripcion;
        this.p_compra = p_compra;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.id_Negocio = id_Negocio;
        this.codigo_barras = codigo_barras;
        this.p_venta = p_venta;
        this.activo = activo;
        this.fecha_actualiza = fecha_actualiza;
        this.minimo = minimo;
        this.maximo = maximo;
        this.id_category = id_category;
    }

    public Product() {
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
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the precioUni
     */
    public double getP_compra() {
        return p_compra;
    }

    /**
     * @param p_compra the precioUni to set
     */
    public void setP_compra(double p_compra) {
        this.p_compra = p_compra;
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
     * @return the id_Negocio
     */
    public int getId_Negocio() {
        return id_Negocio;
    }

    /**
     * @param id_Negocio the id_Negocio to set
     */
    public void setId_Negocio(int id_Negocio) {
        this.id_Negocio = id_Negocio;
    }

    /**
     * @return the codigo_barras
     */
    public BigInteger getCodigo_barras() {
        return codigo_barras;
    }

    /**
     * @param codigo_barras the codigo_barras to set
     */
    public void setCodigo_barras(BigInteger codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    /**
     * @return the p_venta
     */
    public double getP_venta() {
        return p_venta;
    }

    /**
     * @param p_venta the p_venta to set
     */
    public void setP_venta(double p_venta) {
        this.p_venta = p_venta;
    }

    /**
     * @return the activo
     */
    public int getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }

    /**
     * @return the fecha_actualiza
     */
    public String getFecha_actualiza() {
        return fecha_actualiza;
    }

    /**
     * @param fecha_actualiza the fecha_actualiza to set
     */
    public void setFecha_actualiza(String fecha_actualiza) {
        this.fecha_actualiza = fecha_actualiza;
    }

    /**
     * @return the minimo
     */
    public String getMinimo() {
        return minimo;
    }

    /**
     * @param minimo the minimo to set
     */
    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    /**
     * @return the maximo
     */
    public String getMaximo() {
        return maximo;
    }

    /**
     * @param maximo the maximo to set
     */
    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    /**
     * @return the id_category
     */
    public String getId_category() {
        return id_category;
    }

    /**
     * @param id_category the id_category to set
     */
    public void setId_category(String id_category) {
        this.id_category = id_category;
    }
}