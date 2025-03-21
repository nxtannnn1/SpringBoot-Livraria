package com.example.aula.controller;
import com.example.aula.model.Usuario;
import com.example.aula.repository.UsuarioRepository;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

@Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List <Usuario> getUsuarios(){

        List<Usuario> usuarios = usuarioRepository.findAll();
        StringBuilder response = new StringBuilder();
        return usuarioRepository.findAll();
    }

    }
