package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GRA_COUNTRY")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_COUNTRY")
    private BigInteger pIdCountry;
    
    @Column(name = "NAME")
    private String pName;
    
    @Column(name = "DESCRIPTION")
    private String pDescription;
    
    @Column(name = "LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pLastUpdate;
    
    @Column(name = "ACTIVE")
    private char pActive;

    public Country() {
    }

    public Country(BigInteger pIdCountry, String pName, String pDescription, Date pLastUpdate, char pActive) {
        this.pIdCountry = pIdCountry;
        this.pName = pName;
        this.pDescription = pDescription;
        this.pLastUpdate = pLastUpdate;
        this.pActive = pActive;
    }

    public BigInteger getpIdCountry() {
        return pIdCountry;
    }

    public void setpIdCountry(BigInteger pIdCountry) {
        this.pIdCountry = pIdCountry;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public Date getpLastUpdate() {
        return pLastUpdate;
    }

    public void setpLastUpdate(Date pLastUpdate) {
        this.pLastUpdate = pLastUpdate;
    }

    public char getpActive() {
        return pActive;
    }

    public void setpActive(char pActive) {
        this.pActive = pActive;
    }
        
}