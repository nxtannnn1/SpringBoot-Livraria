package com.example.aula.controller;

import com.example.aula.model.Usuario;
import com.example.aula.repository.UsuarioRepository;
import com.example.aula.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller serve para gerenciar requisições HTTP, como GET, POST, PUT e DELETE (CRUD)
//Recebe a requisição, chama os serviços e retorna as respostas
//Mapeia a URL e chama o serviço
@RestController //Controlador para criar serviços RESTful
//Retorna dados, permite que a classe manipule solicitações GET, POST... etc
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired //Injeta dependências nas classes
    //Assim o Spring instancia automaticamente, sem precisar vc fazer isso

    private UsuarioService usuarioService;

    @GetMapping //Endpoint/URL
    public String welcome(){
        return "Testes Spring";
    }

    @GetMapping("/retornar-usuarios")//Endpoint/URL
    public List<Usuario> getUsuarios() {
        return usuarioService.buscarUsuarios(); //Retorna todos os registros do usuario guardados no BD
    }

    @PostMapping("/cadastrar-usuarios")
    public Usuario setUsuarios(@RequestBody Usuario usuario){
        System.out.println(usuario);
        return usuarioService.salvarUsuario(usuario);
    }

}
