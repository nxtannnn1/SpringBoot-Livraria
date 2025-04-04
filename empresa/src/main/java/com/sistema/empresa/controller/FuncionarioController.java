package com.sistema.empresa.controller;

import com.sistema.empresa.model.Funcionario;
import com.sistema.empresa.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller REST da API
@RequestMapping("/funcionarios") //Define a URL básica do site
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) { //Poderia utilizar autowired para extinguir a existência do construtor
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody Funcionario funcionario) {
        Funcionario salvo = funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado!");
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarFuncionario();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> excluir(@PathVariable String cpf) {
        funcionarioService.excluir(cpf);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        // Certifique-se de que o ID da URL seja atribuído ao objeto funcionario
        funcionario.setId(id);  // Aqui o id da URL é atribuído ao objeto `funcionario`
        Funcionario atualizado = funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/penis")
    public ResponseEntity<String> testes(){
        return ResponseEntity.ok("Testes");
    }
}
