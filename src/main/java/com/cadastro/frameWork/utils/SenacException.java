package com.cadastro.frameWork.utils;

import java.util.ArrayList;
import java.util.List;

public class SenacException extends Exception{
    private List<String> messages = new ArrayList<>();

    // Precisa declarar o construtor
    public SenacException(String message) {
        super(message);
    }
    // Precisa declarar outro construtor só para a lista de mensagem
    public SenacException(List<String> msg) {
        this.messages = msg;

    }

    public List<String> getMessages() {
        return messages;
    }
}
