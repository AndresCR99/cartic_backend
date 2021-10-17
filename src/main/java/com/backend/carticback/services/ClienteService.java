package com.backend.carticback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.ClienteRepository;
import com.backend.carticback.models.ClienteModel;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> getUsers(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel saveUser(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    
    public Optional<ClienteModel> getById(long id){
        return clienteRepository.findById(id);
    }

    public boolean deleteUser(Long id){
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
