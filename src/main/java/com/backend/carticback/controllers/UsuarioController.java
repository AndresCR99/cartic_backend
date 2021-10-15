package com.backend.carticback.controllers;

import java.util.ArrayList;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.modelmapper.ModelMapper;

import com.backend.carticback.entities.requests.UsuarioRegistrarRequestModel ;
import com.backend.carticback.entities.responses.UsuarioRestModel;
import com.backend.carticback.models.UsuarioModel;
import com.backend.carticback.services.IUsuarioService;
import com.backend.carticback.shared.UsuarioCrearDto;
import com.backend.carticback.shared.UsuarioDto;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    
    @Autowired
    IUsuarioService iUsuarioServicio;
    
    
    @Autowired
    ModelMapper modelmapper;
    
    // // @PostMapping("/login")
    // // public UsuarioModel login(@RequestBody UsuarioModel usuario){
    // //     return usuario;
    // // }

    @PostMapping()
    public UsuarioRestModel crearUsuario(@RequestBody @Valid UsuarioRegistrarRequestModel usuarioRegistroRequestModel){
       
        UsuarioCrearDto usuarioCrearDto= modelmapper.map(usuarioRegistroRequestModel, UsuarioCrearDto.class);
        
        UsuarioDto usuarioDto= iUsuarioServicio.crearUsuario(usuarioCrearDto);

        UsuarioRestModel usuarioRestModel= modelmapper.map(usuarioDto, UsuarioRestModel.class);

        return usuarioRestModel;
    } 
}
