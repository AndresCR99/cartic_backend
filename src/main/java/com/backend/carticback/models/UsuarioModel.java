package com.backend.carticback.models;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;

    private String correo;
    private String contrasena;

    // @OneToOne
    // @JoinColumn(name ="fk_usuarios_persona", referencedColumnName = "id", unique = true)
    // private PersonaModel persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // public PersonaModel getPersona() {
    //     return persona;
    // }

    // public void setPersona(PersonaModel persona) {
    //     this.persona = persona;
    // }


    
}
