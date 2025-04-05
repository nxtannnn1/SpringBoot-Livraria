package com.example.livraria.exceptions;

public class LivroNaoAchadoException extends RuntimeException {
    public LivroNaoAchadoException(String message) {
        super(message);
    }
}
