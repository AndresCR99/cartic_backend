package com.backend.carticback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import com.backend.carticback.repositories.UsuarioRepository;
import com.backend.carticback.models.UsuarioModel;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> getUsers(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel saveUser(UsuarioModel persona){
        return usuarioRepository.save(persona);
    }

    public Optional<UsuarioModel> getById(long id){
        //optional por si no existe el id no falle
        return usuarioRepository.findById(id);
    }

    public boolean deleteUser(Long id){
        try {
            usuarioRepository.deleteById(id); // no regresa nada
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
