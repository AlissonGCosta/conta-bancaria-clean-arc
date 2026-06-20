package br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions;

public class NotFoundException extends RuntimeException {
    private String code;
    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
