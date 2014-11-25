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
@Table(name = "Sesion")
public class Sesion implements Serializable {

    public static final String CUT_PENDING = "1";
    public static final String ACTIVE = "1";
    public static final String NOT_CUT_PENDING = "0";
    public static final String NOT_ACTIVE = "0";
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_SESION")
    private int idSesion;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "STARTDATE", nullable = false, columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
    private Date startDate;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "CUT_PENDING")
    private String cutPending;
    @ManyToOne
    private Usuario usuario;

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCutPending() {
        return cutPending;
    }

    public void setCutPending(String cutPending) {
        this.cutPending = cutPending;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}