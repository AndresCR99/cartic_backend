package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.TipoPersonaModel;

@Repository
public interface TipoPersonaRepository extends CrudRepository<TipoPersonaModel, Long> {
    
}
