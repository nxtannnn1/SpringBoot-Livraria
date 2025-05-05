package com.sistema.livraria.controller;

import com.sistema.livraria.model.Livro;
import com.sistema.livraria.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controlador REST - É uma classe que lida com requisições HTTP, processa e retorna elementos json
@RequestMapping("/livros") //URL Base
@CrossOrigin(origins = "http://127.0.0.1:5500") //URL do LiveServer - Estou utilizando o VSCode no front-end
public class LivroController {

    private final LivroService livroService;

    /*Injeção de dependência (Instância de LivroService) via construtor
     Melhora a legibilidade, traz clareza, simplifica os testes unitários
     */
    public LivroController (LivroService livroService){
        this.livroService=livroService; //Inicializa a instância e permite seu uso
    }

    @PostMapping
    public ResponseEntity<String> cadastrarLivro(@Valid @RequestBody Livro livro){
        Livro salvo = livroService.cadastrarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro cadastrado com sucesso");
    }

    @GetMapping
    public List<Livro> mostrarLivro(){
        return livroService.mostrarLivros();
    }

    @GetMapping("/{id}")
    public Livro mostrarLivroPorId(@PathVariable Long id){
        return livroService.buscarLivroPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livro){
        livro.setId(id); //Garante que o ID será passado corretamente
        Livro atualizado = livroService.editarLivro(livro);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Livro de ID "+atualizado.getId()+" atualizado");
    }

}
