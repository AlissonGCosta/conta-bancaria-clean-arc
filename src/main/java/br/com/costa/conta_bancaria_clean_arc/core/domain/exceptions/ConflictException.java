package br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions;

public class ConflictException extends RuntimeException {
    private String code;
    public ConflictException(String message,  String code) {

        super(message);
        this.code = code;
    }
}
