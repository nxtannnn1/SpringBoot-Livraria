package com.sistema.livraria.service;

import com.sistema.livraria.exceptions.LivroNaoEncontradoException;
import com.sistema.livraria.model.Livro;
import com.sistema.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Declara que é um Serviço Spring
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository; //Repositório para operações com a entidade Livro

    public LivroService (LivroRepository livroRepository){  //Inicialização do atributo livroRepository
        this.livroRepository=livroRepository;
    }

    public List<Livro> mostrarLivros(){
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(Long id){  //Busca o livro pelo ID,caso não seja possível, lança uma exception personalizada
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("Livro de ID "+id+" não encontrado"));
    }


    public Livro editarLivro(Livro livro){
        if(!livroRepository.existsById(livro.getId())){ //Caso não haja livro com o ID inserido, lança uma exception
            throw new LivroNaoEncontradoException("Livro de ID "+livro.getId()+" não encontrado");
        }
        return livroRepository.save(livro);
    }

    public void excluirLivro(Long id){
        try{
            livroRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){ //Caso não exista o ID, lança uma excecão
           throw new LivroNaoEncontradoException("Livro de ID "+id+" não encontrado");
        }
    }

    public Livro cadastrarLivro(Livro livro){
        return livroRepository.save(livro);
    }
}
