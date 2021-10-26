package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.OrdenServicioModel;

@Repository
public interface OrdenServicioRepository extends CrudRepository<OrdenServicioModel, Long> {
    
}
