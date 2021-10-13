package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.PersonaModel;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel, Long> {

}
