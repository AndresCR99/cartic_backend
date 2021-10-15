package com.backend.carticback.services;

import java.util.List;

import com.backend.carticback.shared.UsuarioCrearDto;
import com.backend.carticback.shared.UsuarioDto;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUsuarioService extends UserDetailsService{

    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto);
    public UsuarioDto obtenerUsuario(String userName);
    
}
