package br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions;

public class BadRequestException extends RuntimeException {
    private String code;
    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }
}
