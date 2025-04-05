package com.example.livraria.service;

import com.example.livraria.exceptions.LivroNaoAchadoException;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void excluirLivro(Long id) {
        try {
            livroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new LivroNaoAchadoException("Livro de ID " + id + " não achado.");
        }
    }

    public Livro atualizarLivro(Livro livro) {
        if (!livroRepository.existsById(livro.getId())) {
            throw new LivroNaoAchadoException("Livro de ID " + livro.getId() + " não existe!");
        }
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }


}
