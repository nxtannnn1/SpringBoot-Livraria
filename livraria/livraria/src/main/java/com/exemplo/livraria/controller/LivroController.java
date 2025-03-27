package com.exemplo.livraria.controller;

import com.exemplo.livraria.model.Livro;
import com.exemplo.livraria.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        List<Livro> livros = service.listarTodos();
        model.addAttribute("livros", livros);
        model.addAttribute("livro", new Livro()); // Para criar um livro no formulário
        return "livros"; // Nome do template Thymeleaf
    }

    @PostMapping
    public String criar(@ModelAttribute Livro livro) {
        service.salvar(livro);
        return "redirect:/livros"; // Redireciona para a página de livros
    }

    @GetMapping("/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Livro livro = service.buscarPorId(id).orElse(null);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "livros"; // Pode criar um template para editar, caso queira separar
    }

    @GetMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/livros"; // Redireciona após deletar
    }
}
