package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.OrdenModel;

@Repository
public interface OrdenRepository extends CrudRepository<OrdenModel, Long> {
    
}
