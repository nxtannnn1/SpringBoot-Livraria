package com.sistema.empresa.repository;

import com.sistema.empresa.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
