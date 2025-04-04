package com.sistema.empresa.model;

import com.sistema.empresa.enums.SEXO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.sistema.empresa.enums.CARGO;

@Entity //Indica que será uma tabela no BD
@Table (name="funcionario") //Define nome da tabela
@Getter
@Setter
@AllArgsConstructor //Construtor com todos os argumentos já inicializados
@NoArgsConstructor //Construtor sem argumentos, serve para inicializar atributos sem atribuir valores
public class Funcionario {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Garante que seja auto_increment no BD
    private Long id;

    @Column(nullable = false) //Tabela BD
    private String nome;
    private Double salario;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private CARGO cargo;
    private SEXO sexo;

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CARGO getCargo() {
        return cargo;
    }

    public void setCargo(CARGO cargo) {
        this.cargo = cargo;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    @OneToOne(cascade = CascadeType.ALL) //Tipo de relacionamento, onde um funcionario tem apenas um endereço cadastrado
    @JoinColumn(name="endereco_id") //Nome da chave estrangeira
    private Endereco endereco;
}
