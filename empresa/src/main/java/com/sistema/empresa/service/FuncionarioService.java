package com.sistema.empresa.service;

import com.sistema.empresa.model.Funcionario;
import com.sistema.empresa.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvarFuncionario(@Valid Funcionario funcionario) {
        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario) {
        if (funcionario.getId() == null) {
            throw new IllegalArgumentException("ID do funcionário não pode ser nulo.");
        }

        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        // Atualize outros campos, se necessário

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void excluir(String cpf){
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        funcionarioRepository.delete(funcionario);


    }
}
