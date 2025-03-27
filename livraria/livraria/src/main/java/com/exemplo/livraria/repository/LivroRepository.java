package com.exemplo.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
