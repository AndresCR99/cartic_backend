package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.VehiculoModel;

@Repository
public interface VehiculoRepository extends CrudRepository<VehiculoModel, Long>{
    
}
