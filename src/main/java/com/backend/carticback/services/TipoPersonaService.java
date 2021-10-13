package com.backend.carticback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.TipoPersonaRepository;
import com.backend.carticback.models.TipoPersonaModel;

@Service
public class TipoPersonaService {

    @Autowired
    TipoPersonaRepository tipoPersonaRepository;

    public ArrayList<TipoPersonaModel> getUsers(){
        return (ArrayList<TipoPersonaModel>) tipoPersonaRepository.findAll();
    }

    public TipoPersonaModel saveUser(TipoPersonaModel persona){
        return tipoPersonaRepository.save(persona);
    }

    
    public Optional<TipoPersonaModel> getById(long id){
        //optional por si no existe el id no falle
        return tipoPersonaRepository.findById(id);
    }

    public boolean deleteUser(Long id){
        try {
            tipoPersonaRepository.deleteById(id); // no regresa nada
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
