package com.example.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.livraria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
