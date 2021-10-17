package com.backend.carticback.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuarios",
indexes = {
    @Index(columnList = "id", name="index_userid", unique = true),
    @Index(columnList = "userName", name="index_username", unique = true), 
    @Index(columnList = "correo", name="index_correo", unique = true) 
})
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;

    @Column(unique=true)
    private String userId;

    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 50)
    private String correo;

    @Column(nullable = false, length = 10)
    private String userName;
    
    @Column(nullable = false)
    private String encryptedPassword;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
