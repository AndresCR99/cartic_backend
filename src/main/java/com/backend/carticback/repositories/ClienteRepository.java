package com.backend.carticback.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.backend.carticback.models.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {

}
