/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt_Usuarios")
public class Usuario implements Serializable{

        @Id
    @Column(name="Id_usuario")
    private int id_usuario;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name="Domicilio")
    private String domicilio;
    @Column(name="Direccion")
    private String direccion;
    @Column(name="tel_casa")
    private String tel_casa;
    @Column(name="tel_movil")
    private String tel_movil;
    @Column(name="cve_usuario")
    private String cve_usuario;
    @Column(name="contrasena")
    private String contrasena;
    @Column(name="bloqueo")
    private int bloqueo;
    @Column(name="is_admin")
    @org.hibernate.annotations.Type(type ="yes_no")
    private boolean is_admin;
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel_casa() {
        return tel_casa;
    }

    public void setTel_casa(String tel_casa) {
        this.tel_casa = tel_casa;
    }

    public String getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(String tel_movil) {
        this.tel_movil = tel_movil;
    }

    public String getCve_usuario() {
        return cve_usuario;
    }

    public void setCve_usuario(String cve_usuario) {
        this.cve_usuario = cve_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(int bloqueo) {
        this.bloqueo = bloqueo;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

}
