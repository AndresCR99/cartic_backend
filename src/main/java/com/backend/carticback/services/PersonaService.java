package com.backend.carticback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.PersonaRepository;
import com.backend.carticback.models.PersonaModel;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<PersonaModel> getUsers(){
        return (ArrayList<PersonaModel>) personaRepository.findAll();
    }

    public PersonaModel saveUser(PersonaModel persona){
        return personaRepository.save(persona);
    }

    
    public Optional<PersonaModel> getById(long id){
        //optional por si no existe el id no falle
        return personaRepository.findById(id);
    }

    public boolean deleteUser(Long id){
        try {
            personaRepository.deleteById(id); // no regresa nada
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
