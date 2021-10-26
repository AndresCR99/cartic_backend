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

import com.backend.carticback.models.OrdenModel;
import com.backend.carticback.services.OrdenService;


@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {
    @Autowired
    OrdenService ordenService;

    @GetMapping()
    public ArrayList<OrdenModel> getUsers(){
        return ordenService.getUsers();
    }

    @PostMapping()
    public OrdenModel saveUser(@RequestBody OrdenModel user){
        return this.ordenService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<OrdenModel> getUserById(@PathVariable("id") Long id){
        return this.ordenService.getById(id);
    }

    @PutMapping()
    public OrdenModel updateUser(@RequestBody OrdenModel user){
        return this.ordenService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.ordenService.deleteUser(id);
        if(ok){
            return "User deleted with id: " + id;
        }else{
            return "could not delete user with id: " + id;
        }
    }
}
