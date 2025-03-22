package com.example.aula.model;

import jakarta.persistence.*;

//Models servem para representar as entidades que estarão presentes no banco de dados
//São mapeadas usando JPA (Java Persistence API)

@Entity//Informo ao JPA que essa classe será uma entidade presente no BD
@Table(name="usuario") //Referencio a tabela
public class Usuario {
    @Id //Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera auto-increment em ID
    private Long id;
    private String nome;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
