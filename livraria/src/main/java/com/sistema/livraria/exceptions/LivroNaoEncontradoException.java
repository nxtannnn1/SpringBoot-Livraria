package com.sistema.livraria.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{
    public LivroNaoEncontradoException (String mensagem){
        super(mensagem);
    }
}
