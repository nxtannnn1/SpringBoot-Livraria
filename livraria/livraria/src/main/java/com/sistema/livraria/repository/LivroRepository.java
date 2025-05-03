package com.sistema.livraria.repository;

import com.sistema.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Interface responsável pelo acesso aos dados da Entidade Livro
public interface LivroRepository extends JpaRepository<Livro, Long> {

    //Através do JpaRepository, tenho acesso a várias funções importantes para o CRUD, como FindBy, Save, Delete, etc...

}
