package com.exemplo.livraria.dto;

public class LivroDTO { //DTO = Data Transfer Object - utilizado para transferir dado's de forma mais simples
    private String titulo;
    private String autor;
    private Integer paginas;

    public LivroDTO(String titulo, String autor, Integer paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

}

