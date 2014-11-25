package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "GRA_STATE")
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_STATE")
    private BigInteger pIdState;
    @Column(name = "NAME")
    private String pName;
    @Column(name = "DESCRIPTION")
    private String pDescription;
    @ManyToOne
    private Country gra_country;
    @Column(name = "LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pLastUpdate;
    @Column(name = "ACTIVE")
    private char pActive;

    public State() {
    }

    public State(BigInteger pIdState, String pName, String pDescription, Country pCountry, Date pLastUpdate, char pActive) {
        this.pIdState = pIdState;
        this.pName = pName;
        this.pDescription = pDescription;
        this.gra_country = pCountry;
        this.pLastUpdate = pLastUpdate;
        this.pActive = pActive;
    }

    public BigInteger getpIdState() {
        return pIdState;
    }

    public void setpIdState(BigInteger pIdState) {
        this.pIdState = pIdState;
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

    public Country getpCountry() {
        return gra_country;
    }

    public void setpCountry(Country pCountry) {
        this.gra_country = pCountry;
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