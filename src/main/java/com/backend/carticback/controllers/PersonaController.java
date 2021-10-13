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

import com.backend.carticback.models.PersonaModel;
import com.backend.carticback.services.PersonaService;


@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;

    @GetMapping()
    public ArrayList<PersonaModel> getUsers(){
        return personaService.getUsers();
    }

    @PostMapping()
    public PersonaModel saveUser(@RequestBody PersonaModel user){
        // @RequestBody permite enviar parametros dentro de la solicitud
        //Guarda el usuario y lo retorna con su id
        // este metodo sirve para actualizar solo hayq ue pasarle el id y actualizar los otros campos
        return this.personaService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<PersonaModel> getUserById(@PathVariable("id") Long id){
        // buscar por id http://localhost:8080/api/users/2
        return this.personaService.getById(id);
    }

    @PutMapping()
    public PersonaModel updateUser(@RequestBody PersonaModel user){
        return this.personaService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.personaService.deleteUser(id);
        if(ok){
            return "User deleted with id: " + id;
        }else{
            return "could not delete user with id: " + id;
        }
    }



}
