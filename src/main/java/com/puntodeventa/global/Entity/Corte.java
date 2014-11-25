package com.puntodeventa.global.Entity;

import com.puntodeventa.global.Util.Util;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Corte")
public class Corte implements Serializable {

    public Corte() {
    }

    public Corte(int id_folio, Date fecha, Usuario id_usuario, int ventafolio_from, int ventafolio_to, double total_preciocompra, double total_precioventa, int numero_de_ventas, double total_corte, double efvoInicial, double efvoVaja) {
        this.id_folio = id_folio;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.ventafolio_from = ventafolio_from;
        this.ventafolio_to = ventafolio_to;
        this.total_preciocompra = total_preciocompra;
        this.total_precioventa = total_precioventa;
        this.numero_de_ventas = numero_de_ventas;
        this.total_corte = total_corte;
        this.efvoInicial = efvoInicial;
        this.efvoCaja = efvoVaja;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_FOLIO")
    private int id_folio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA")
    private Date fecha = Util.getDate();
    @ManyToOne
    private Usuario id_usuario = Util.getCurrentUser();
    @Column(name = "FOLIOVENTA_FROM")
    private int ventafolio_from;
    @Column(name = "FOLIOVENTA_TO")
    private int ventafolio_to;
    @Column(name = "TOTAL_PRECIOCOMPRA")
    private double total_preciocompra = 0;
    @Column(name = "TOTAL_PRECIOVENTA")
    private double total_precioventa = 0;
    @Column(name = "NUMERO_DE_VENTAS")
    private int numero_de_ventas;
    @Column(name = "TOTAL_CORTE")
    private double total_corte = 0;
    @Column(name = "EFVO_INICIAL")
    private double efvoInicial = 0;
    @Column(name = "EFVO_CAJA")
    private double efvoCaja = 0;

    public int getId_folio() {
        return id_folio;
    }

    public void setId_folio(int id_folio) {
        this.id_folio = id_folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getVentafolio_from() {
        return ventafolio_from;
    }

    public void setVentafolio_from(int ventafolio_from) {
        this.ventafolio_from = ventafolio_from;
    }

    public int getVentafolio_to() {
        return ventafolio_to;
    }

    public void setVentafolio_to(int ventafolio_to) {
        this.ventafolio_to = ventafolio_to;
    }

    public double getTotal_preciocompra() {
        return total_preciocompra;
    }

    public void setTotal_preciocompra(double total_preciocompra) {
        this.total_preciocompra = total_preciocompra;
    }

    public double getTotal_precioventa() {
        return total_precioventa;
    }

    public void setTotal_precioventa(double total_precioventa) {
        this.total_precioventa = total_precioventa;
    }

    public int getNumero_de_ventas() {
        return numero_de_ventas;
    }

    public void setNumero_de_ventas(int numero_de_ventas) {
        this.numero_de_ventas = numero_de_ventas;
    }

    public double getTotal_corte() {
        return total_corte;
    }

    public void setTotal_corte(double total_corte) {
        this.total_corte = total_corte;
    }

    public double getEfvoInicial() {
        return efvoInicial;
    }

    public void setEfvoInicial(double efvoInicial) {
        this.efvoInicial = efvoInicial;
    }

    public double getEfvoCaja() {
        return efvoCaja;
    }

    public void setEfvoCaja(double efvoCaja) {
        this.efvoCaja = efvoCaja;
    }
}