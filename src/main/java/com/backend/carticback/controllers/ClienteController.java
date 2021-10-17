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

import com.backend.carticback.models.ClienteModel;
import com.backend.carticback.services.ClienteService;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> getUsers(){
        return clienteService.getUsers();
    }

    @PostMapping()
    public ClienteModel saveUser(@RequestBody ClienteModel user){
        return this.clienteService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> getUserById(@PathVariable("id") Long id){
        return this.clienteService.getById(id);
    }

    @PutMapping()
    public ClienteModel updateUser(@RequestBody ClienteModel user){
        return this.clienteService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.clienteService.deleteUser(id);
        if(ok){
            return "User deleted with id: " + id;
        }else{
            return "could not delete user with id: " + id;
        }
    }



}
