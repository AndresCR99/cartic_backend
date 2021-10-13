package com.backend.carticback.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.carticback.models.TipoPersonaModel;
import com.backend.carticback.services.TipoPersonaService;

@RestController
@RequestMapping("/api/tipoPersonas")
public class TipoPersonaController {
    @Autowired
    TipoPersonaService tipoPersonaService;

    @GetMapping()
    public ArrayList<TipoPersonaModel> getUsers(){
        return tipoPersonaService.getUsers();
    }

    @PostMapping()
    public TipoPersonaModel saveUser(@RequestBody TipoPersonaModel user){
        return this.tipoPersonaService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<TipoPersonaModel> getUserById(@PathVariable("id") Long id){
        return this.tipoPersonaService.getById(id);
    }

    @PutMapping()
    public TipoPersonaModel updateUser(@RequestBody TipoPersonaModel user){
        return this.tipoPersonaService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.tipoPersonaService.deleteUser(id);
        if(ok){
            return "User deleted with id: " + id;
        }else{
            return "could not delete user with id: " + id;
        }
    }
}
