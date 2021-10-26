package com.backend.carticback.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.VehiculoRepository;
import com.backend.carticback.models.VehiculoModel;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public ArrayList<VehiculoModel> getUsers(){
        return (ArrayList<VehiculoModel>) vehiculoRepository.findAll();
    }

    public VehiculoModel saveUser(VehiculoModel vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    public Optional<VehiculoModel> getById(long id){
        return vehiculoRepository.findById(id);
    }

    public ArrayList<VehiculoModel> getByPrioridad(String placa){
        return vehiculoRepository.findByPlaca(placa);
    }

    public boolean deleteUser(Long id){
        try {
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
