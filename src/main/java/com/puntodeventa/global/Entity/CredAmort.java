/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jehernandez
 */
@Entity
@Table(name = "CRED_AMORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CredAmort.findAll", query = "SELECT c FROM CredAmort c"),
    @NamedQuery(name = "CredAmort.findByCveCliente", query = "SELECT c FROM CredAmort c WHERE c.credAmortPK.cveCliente = :cveCliente"),
    @NamedQuery(name = "CredAmort.findByIdFolio", query = "SELECT c FROM CredAmort c WHERE c.credAmortPK.idFolio = :idFolio"),
    @NamedQuery(name = "CredAmort.findByDebt", query = "SELECT c FROM CredAmort c WHERE c.debt = :debt"),
    @NamedQuery(name = "CredAmort.findByDeposit", query = "SELECT c FROM CredAmort c WHERE c.deposit = :deposit"),
    @NamedQuery(name = "CredAmort.findByDateMov", query = "SELECT c FROM CredAmort c WHERE c.dateMov = :dateMov")})
public class CredAmort implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CredAmortPK credAmortPK;
    @Basic(optional = false)
    @Column(name = "DEBT")
    private BigInteger debt;
    @Column(name = "DEPOSIT")
    private BigInteger deposit;
    @Column(name = "DATE_MOV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMov;
    @JoinColumn(name = "ID_FOLIO", referencedColumnName = "ID_FOLIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta ventas;
    @JoinColumn(name = "CVE_CLIENTE", referencedColumnName = "CVE_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public CredAmort() {
    }

    public CredAmort(CredAmortPK credAmortPK) {
        this.credAmortPK = credAmortPK;
    }

    public CredAmort(CredAmortPK credAmortPK, BigInteger debt) {
        this.credAmortPK = credAmortPK;
        this.debt = debt;
    }

    public CredAmort(BigInteger cveCliente, BigInteger idFolio) {
        this.credAmortPK = new CredAmortPK(cveCliente, idFolio);
    }

    public CredAmortPK getCredAmortPK() {
        return credAmortPK;
    }

    public void setCredAmortPK(CredAmortPK credAmortPK) {
        this.credAmortPK = credAmortPK;
    }

    public BigInteger getDebt() {
        return debt;
    }

    public void setDebt(BigInteger debt) {
        this.debt = debt;
    }

    public BigInteger getDeposit() {
        return deposit;
    }

    public void setDeposit(BigInteger deposit) {
        this.deposit = deposit;
    }

    public Date getDateMov() {
        return dateMov;
    }

    public void setDateMov(Date dateMov) {
        this.dateMov = dateMov;
    }

    public Venta getVentas() {
        return ventas;
    }

    public void setVentas(Venta ventas) {
        this.ventas = ventas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (credAmortPK != null ? credAmortPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CredAmort)) {
            return false;
        }
        CredAmort other = (CredAmort) object;
        if ((this.credAmortPK == null && other.credAmortPK != null) || (this.credAmortPK != null && !this.credAmortPK.equals(other.credAmortPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puntodeventa.persistence.Entity.CredAmort[ credAmortPK=" + credAmortPK + " ]";
    }
    
}
