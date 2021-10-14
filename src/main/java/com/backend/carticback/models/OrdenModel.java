package com.backend.carticback.models;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ordenes")
public class OrdenModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
    @Column(name="created_date", nullable = false)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name ="fk_vehiculos", referencedColumnName = "id")
    private VehiculoModel vehiculo;

    @ManyToOne
    @JoinColumn(name ="fk_personas", referencedColumnName = "id")
    private PersonaModel persona;

    @OneToMany
    @JoinColumn(name ="fk_orden", referencedColumnName = "id")
    private List<ServicioModel> servicios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public PersonaModel getPersona() {
        return persona;
    }

    public void setPersona(PersonaModel persona) {
        this.persona = persona;
    }

    public List<ServicioModel> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioModel> servicios) {
        this.servicios = servicios;
    }








}
