package com.backend.carticback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.OrdenServicioRepository;
import com.backend.carticback.models.OrdenServicioModel;

@Service
public class OrdenServicioService {
    
    @Autowired
    OrdenServicioRepository ordenServicioRepository;

    public ArrayList<OrdenServicioModel> getOrdenServicios(){
        return (ArrayList<OrdenServicioModel>) ordenServicioRepository.findAll();
    }

    public OrdenServicioModel saveOrdenServicio(OrdenServicioModel orden){
        return ordenServicioRepository.save(orden);
    }

    
    public Optional<OrdenServicioModel> getById(long id){
        return ordenServicioRepository.findById(id);
    }

    public boolean deleteOrdenServicio(Long id){
        try {
            ordenServicioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
