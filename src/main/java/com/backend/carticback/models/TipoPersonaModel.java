package com.backend.carticback.models;

import javax.persistence.*;

@Entity
@Table(name="tipo_persona")
public class TipoPersonaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;

    private String rol;

    // @OneToMany
    // private List<PersonaModel> persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // public List<PersonaModel> getPersona() {
    //     return persona;
    // }

    // public void setPersona(List<PersonaModel> persona) {
    //     this.persona = persona;
    // }

}
