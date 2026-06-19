package br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.enums;

public enum ErrorCodeEnum {

    ON0001("Invalid Tax Number", "ON-0001"),
    ON0002("Unavailable Tax Number", "ON-0002"),

    AM0001("Negative Amount not possible", "AM-0001"),

    TRA001("Transfer not possible for same accounts", "TRA-001"),
    TRA002("Transfer is not possible with negatives value", "TRA-002"),


    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
