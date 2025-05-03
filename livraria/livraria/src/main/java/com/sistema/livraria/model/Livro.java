package com.sistema.livraria.model;

import com.sistema.livraria.enums.CATEGORIA;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Declara que é uma entidade no JPA
@AllArgsConstructor //Construtor, inicializa o objeto com todos os argumentos
@NoArgsConstructor //Construtor, inicializa o objeto sem argumentos
@Table(name="livro") //Define o nome da tabela no banco de dados
@Getter //Define métodos get para os atributos - Receber
@Setter //Define métodos set para os atributos - Definir
public class Livro {

    @Id //Primary-Key no Banco de Dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Primary-Key AutoIncrement, ou seja, não é preciso colocar manualmente o id dos livros, e é acrescentado "1" unidade a cada livro
    private Long id;

    @NotBlank(message = "Título não pode ser vazio")
    @Column(nullable = false) //Evita valores nulos
    private String titulo;

    @NotNull(message = "É obrigatório ter páginas")
    @Min(value = 1, message = "É necessário haver ao menos 1 página")
    @Column(nullable = false)
    private Integer paginas; //Integer é uma classe, possui métodos, pode ser null (ideal para BD), validações @NotNull

    @Enumerated(EnumType.STRING) //Armazena o nome da constante como texto
    @NotNull(message = "É necessário inserir uma categoria")
    @Column(nullable = false)
    private CATEGORIA categoria;

    public Livro(Long id, String titulo, Integer paginas, CATEGORIA categoria) { //Inicialização dos atributos da classe Livro através do Construtor
        this.id = id;
        this.titulo = titulo;
        this.paginas = paginas;
        this.categoria = categoria;
    }

    public Livro() { //Construtor vazio - Não é preciso inicializar os atributos
    }

    //Métodos Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public CATEGORIA getCategoria() {
        return categoria;
    }

    public void setCategoria(CATEGORIA categoria) {
        this.categoria = categoria;
    }
}
