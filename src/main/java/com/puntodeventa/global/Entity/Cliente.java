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
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "CVE_CLIENTE")
    private BigInteger cveCliente;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AP")
    private String ap;
    @Column(name = "AM")
    private String am;
    @Column(name = "STREET")
    private String street;
    @Column(name = "STREETNUMBER")
    private int streetNumber;
    @Column(name = "COLONY")
    private String colony;
    @ManyToOne
    private Munic munic;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_PAYMENT")
    private Date datePayment;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "CELL_PHONE")
    private String cellPhone;

    public Cliente(BigInteger cveCliente, String name, String ap, String am, String street, int streetNumber, String colony, Munic munic, Date datePayment, String homePhone, String cellPhone) {
        this.cveCliente = cveCliente;
        this.name = name;
        this.ap = ap;
        this.am = am;
        this.street = street;
        this.streetNumber = streetNumber;
        this.colony = colony;
        this.munic = munic;
        this.datePayment = datePayment;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
    }

    public Cliente() {
    }

    public BigInteger getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(BigInteger cveCliente) {
        this.cveCliente = cveCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public Munic getMunic() {
        return munic;
    }

    public void setMunic(Munic munic) {
        this.munic = munic;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
