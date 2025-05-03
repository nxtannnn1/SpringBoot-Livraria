package com.sistema.livraria.controller;

import com.sistema.livraria.model.Livro;
import com.sistema.livraria.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controlador REST
@RequestMapping("/livros") //URL Base
@CrossOrigin(origins = "http://127.0.0.1:5500") //URL do LiveServer
public class LivroController {

    @Autowired //Injeção de dependência
    private final LivroService livroService;

    public LivroController (LivroService livroService){
        this.livroService=livroService;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirLivro (@PathVariable Long id){
        livroService.excluirLivro(id);
        return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso!");
    }
}
