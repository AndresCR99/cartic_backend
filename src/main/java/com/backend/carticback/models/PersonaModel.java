package com.backend.carticback.models;
import javax.persistence.*;
// import java.util.List;

@Entity
@Table(name="persona")
public class PersonaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;

    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name ="fk_tipo_usuarios", referencedColumnName = "id")
    private TipoPersonaModel tipoPersona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoPersonaModel getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaModel tipoPersona) {
        this.tipoPersona = tipoPersona;
    }



}
