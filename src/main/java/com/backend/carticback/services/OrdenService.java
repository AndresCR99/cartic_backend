package com.backend.carticback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.OrdenRepository;
import com.backend.carticback.models.OrdenModel;

@Service
public class OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    public ArrayList<OrdenModel> getUsers(){
        return (ArrayList<OrdenModel>) ordenRepository.findAll();
    }

    public OrdenModel saveUser(OrdenModel orden){
        return ordenRepository.save(orden);
    }

    
    public Optional<OrdenModel> getById(long id){
        //optional por si no existe el id no falle
        return ordenRepository.findById(id);
    }

    public boolean deleteUser(Long id){
        try {
            ordenRepository.deleteById(id); // no regresa nada
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
