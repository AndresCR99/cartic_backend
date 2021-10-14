package com.backend.carticback.models;
import javax.persistence.*;


@Entity
@Table(name="tipo_servicios")
public class TipoServicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;
    
    @Column(name="nombre_servicio", nullable = false)
    private String nombreServicio;
    
    @Column(name="valor_servicio")
    private Double valorSericio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Double getValorSericio() {
        return valorSericio;
    }

    public void setValorSericio(Double valorSericio) {
        this.valorSericio = valorSericio;
    }
    
}
