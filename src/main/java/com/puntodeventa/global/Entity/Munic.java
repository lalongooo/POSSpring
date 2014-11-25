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
@Table(name = "GRA_MUNIC")
public class Munic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID_MUNIC")
    private BigInteger pIdMunic;
    @Column(name = "NAME")
    private String pName;
    @Column(name = "DESCRIPTION")
    private String pDescription;
    @ManyToOne
    private State gra_state;
    @Column(name = "LASTUPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pLastUpdate;
    @Column(name = "ACTIVE")
    private char pActive;

    public Munic() {
    }

    public Munic(BigInteger pIdMunic, String pName, String pDescription, State pState, Date pLastUpdate, char pActive) {
        this.pIdMunic = pIdMunic;
        this.pName = pName;
        this.pDescription = pDescription;
        this.gra_state = pState;
        this.pLastUpdate = pLastUpdate;
        this.pActive = pActive;
    }
    
    
    public BigInteger getpIdMunic() {
        return pIdMunic;
    }

    public void setpIdMunic(BigInteger pIdMunic) {
        this.pIdMunic = pIdMunic;
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

    public State getpState() {
        return gra_state;
    }

    public void setpState(State pState) {
        this.gra_state = pState;
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