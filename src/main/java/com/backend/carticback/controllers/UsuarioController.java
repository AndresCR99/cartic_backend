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

import com.backend.carticback.models.UsuarioModel;
import com.backend.carticback.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getUsers(){
        return usuarioService.getUsers();
    }

    @PostMapping()
    public UsuarioModel saveUser(@RequestBody UsuarioModel user){
        return this.usuarioService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUserById(@PathVariable("id") Long id){
        return this.usuarioService.getById(id);
    }

    @PutMapping()
    public UsuarioModel updateUser(@RequestBody UsuarioModel user){
        return this.usuarioService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.deleteUser(id);
        if(ok){
            return "User deleted with id: " + id;
        }else{
            return "could not delete user with id: " + id;
        }
    }
}
