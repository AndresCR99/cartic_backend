package com.backend.carticback.models;
import javax.persistence.*;


@Entity
@Table(name="servicios")
public class ServicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;

    @Column(name="detalle_servicio")
    private String detalleServicio;

    @ManyToOne
    @JoinColumn(name ="fk_tipo_servicios", referencedColumnName = "id")
    private TipoServicioModel tipoServicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(String detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    public TipoServicioModel getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicioModel tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
}
