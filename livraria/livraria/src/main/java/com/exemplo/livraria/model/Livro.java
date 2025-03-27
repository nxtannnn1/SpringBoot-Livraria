package com.exemplo.livraria.model;

import jakarta.persistence.*; //Importa as anotações do JPA, que são necessárias para implementação no BD

@Entity //Indica que será uma entidade no banco de dados
@Table(name="livros") //Indica que a tabela no banco de dados se chamará livros

public class Livro { //Classe que representa um livro
    @Id //Indica que é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que o campo será um auto-increment
    private Long id;

    private String titulo;
    private String autor;
    private Integer paginas; //Bom para utilizar quando relacionados a objetos

    public Livro() { //Construtor vazio
    }

    public Livro(String titulo, String autor, Integer paginas) { //Construtor com parâmetros
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
