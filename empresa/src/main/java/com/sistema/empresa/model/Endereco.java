package com.sistema.empresa.model;


import jakarta.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String rua;
    private String logradouro;
    private String cep;
    private String uf;

    @OneToOne(mappedBy = "endereco")
    private Funcionario funcionario;

}
