package com.sistema.empresa.controller;

import com.sistema.empresa.model.Funcionario;
import com.sistema.empresa.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        Funcionario salvo = funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
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

    @PutMapping
    public ResponseEntity<Funcionario> atualizar(@RequestBody Funcionario funcionario) {
        Funcionario atualizado = funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok(atualizado);
    }
}
