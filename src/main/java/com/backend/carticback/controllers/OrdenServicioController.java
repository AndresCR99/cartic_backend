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

import com.backend.carticback.models.OrdenServicioModel;
import com.backend.carticback.services.OrdenServicioService;

@RestController
@RequestMapping("/api/ordenes_servicios")
public class OrdenServicioController {
    
    @Autowired
    OrdenServicioService ordenService;

    @GetMapping()
    public ArrayList<OrdenServicioModel> getUsers(){
        return ordenService.getOrdenServicios();
    }

    @PostMapping()
    public OrdenServicioModel saveUser(@RequestBody OrdenServicioModel orden){
        return this.ordenService.saveOrdenServicio(orden);
    }

    @GetMapping(path = "/{id}")
    public Optional<OrdenServicioModel> getUserById(@PathVariable("id") Long id){
        return this.ordenService.getById(id);
    }

    @PutMapping()
    public OrdenServicioModel updateUser(@RequestBody OrdenServicioModel orden){
        return this.ordenService.saveOrdenServicio(orden);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.ordenService.deleteOrdenServicio(id);
        if(ok){
            return "Service deleted with id: " + id;
        }else{
            return "could not delete service with id: " + id;
        }
    }
}
