package com.leandromendes25.notificacao.infrastructure.exceptions;

public class EmailException extends RuntimeException{
    public EmailException(String mensagem){
        super(mensagem);
    }
}
