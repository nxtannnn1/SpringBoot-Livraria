package com.example.livraria.service;

import com.example.livraria.exceptions.LivroNaoAchadoException;
import com.example.livraria.exceptions.UsuarioNaoAchadoException;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Usuario;
import com.example.livraria.repository.UsuarioRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UsuarioNaoAchadoException("Usuario de ID " + id + " não achado.");
        }
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new UsuarioNaoAchadoException("Usuario de ID " + usuario.getId() + " não achado.");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }


}
