/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jehernandez
 */
@Embeddable
public class CredAmortPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CVE_CLIENTE")
    private BigInteger cveCliente;
    @Basic(optional = false)
    @Column(name = "ID_FOLIO")
    private BigInteger idFolio;

    public CredAmortPK() {
    }

    public CredAmortPK(BigInteger cveCliente, BigInteger idFolio) {
        this.cveCliente = cveCliente;
        this.idFolio = idFolio;
    }

    public BigInteger getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(BigInteger cveCliente) {
        this.cveCliente = cveCliente;
    }

    public BigInteger getIdFolio() {
        return idFolio;
    }

    public void setIdFolio(BigInteger idFolio) {
        this.idFolio = idFolio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cveCliente != null ? cveCliente.hashCode() : 0);
        hash += (idFolio != null ? idFolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CredAmortPK)) {
            return false;
        }
        CredAmortPK other = (CredAmortPK) object;
        if ((this.cveCliente == null && other.cveCliente != null) || (this.cveCliente != null && !this.cveCliente.equals(other.cveCliente))) {
            return false;
        }
        if ((this.idFolio == null && other.idFolio != null) || (this.idFolio != null && !this.idFolio.equals(other.idFolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puntodeventa.persistence.Entity.CredAmortPK[ cveCliente=" + cveCliente + ", idFolio=" + idFolio + " ]";
    }
    
}
