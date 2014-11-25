package com.puntodeventa.global.Entity;

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

/**
 * @author USER
 */
@Entity
@Table(name = "Ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_FOLIO")
    private int idFolio;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToOne
    private Usuario usuario;
    @Column(name = "CVE_CLIENTE")
    private int cveCliente;
    @Column(name = "CANTIDAD")
    private double cantidad;
    @Column(name = "TOTAL")
    private double total;
    @Column(name = "EFECTIVO")
    private double efectivo;
    @Column(name = "CAMBIO")
    private double cambio;

    public Venta(int idFolio, Date fecha, Usuario usuario, int cveCliente, double cantidad, double total, double efectivo, double cambio) {
        this.idFolio = idFolio;
        this.fecha = fecha;
        this.usuario = usuario;
        this.cveCliente = cveCliente;
        this.cantidad = cantidad;
        this.total = total;
        this.efectivo = efectivo;
        this.cambio = cambio;
    }

    public Venta() {
    }

    public int getIdFolio() {
        return this.idFolio;
    }

    public void setIdFolio(int idFolio) {
        this.idFolio = idFolio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return usuario;
    }

    public void setIdUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(int cveCliente) {
        this.cveCliente = cveCliente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
}
