package com.backend.carticback.repositories;

import com.backend.carticback.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    
    public UsuarioModel findByCorreo(String correo);
    public UsuarioModel findByUserName(String userName);

}
