package com.automacao.backend.application.infrastructure.exception;

public class DataAlreadyRegistered extends RuntimeException {
    public DataAlreadyRegistered(String message) {
        super(message);
    }
}
