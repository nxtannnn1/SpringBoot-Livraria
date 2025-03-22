package com.example.aula.repository;

import com.example.aula.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface que interage ao banco de dados sem necessidade de escrevermos
@Repository //Anotação Repositório para interagir com o BD
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //Padrão, mudo apenas o <> para o tipo de Entidade/Classe e sua PrimaryKey

    //Posso colocar consultas personalizadas aqui
}
