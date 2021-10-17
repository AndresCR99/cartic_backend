package com.backend.carticback.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.backend.carticback.models.UsuarioModel;
import com.backend.carticback.repositories.IUsuarioRepository;
import com.backend.carticback.errors.UsuarioExisteException;
import com.backend.carticback.shared.UsuarioCrearDto;
import com.backend.carticback.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{ 

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository; 

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;



    @Override
    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto) {

        if(iUsuarioRepository.findByCorreo(usuarioCrearDto.getCorreo()) != null){
            throw new UsuarioExisteException("Este correo ya se encuentra registrado");
        }

        if(iUsuarioRepository.findByUserName(usuarioCrearDto.getUserName()) != null){
            throw new UsuarioExisteException("Este nombre de usuario ya esta en uso");
        }
         
         
        UsuarioModel usuarioEntityDto= modelmapper.map(usuarioCrearDto, UsuarioModel.class);
        usuarioEntityDto.setEncryptedPassword(bcryptPasswordEncoder.encode(usuarioCrearDto.getPassword()));
        usuarioEntityDto.setUserId(UUID.randomUUID().toString());

        UsuarioModel usuarioEntitySave=iUsuarioRepository.save(usuarioEntityDto);
        
        UsuarioDto usuarioDto= modelmapper.map(usuarioEntitySave, UsuarioDto.class);
      
        return usuarioDto;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        UsuarioModel usuarioModel = iUsuarioRepository.findByUserName(userName);

        if(usuarioModel==null) {
            throw new UsernameNotFoundException(userName);
        }
        
        return new User(usuarioModel.getUserName(), usuarioModel.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UsuarioDto obtenerUsuario(String userName) {

        UsuarioModel usuarioModel = iUsuarioRepository.findByUserName(userName);
        
        if(usuarioModel==null){
            throw new UsernameNotFoundException(userName);
        }

        UsuarioDto usuarioDtoObtenido= modelmapper.map(usuarioModel, UsuarioDto.class);

        return usuarioDtoObtenido;
    }
    
}
