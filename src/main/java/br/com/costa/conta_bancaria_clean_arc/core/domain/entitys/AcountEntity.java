package br.com.costa.conta_bancaria_clean_arc.core.domain.entitys;

import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.BadRequestException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.util.UUID;


public class AcountEntity {

    private UUID id;
    private String name;
    private String taxNumber;
    private String password;
    private BigDecimal amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null||amount.compareTo(BigDecimal.ZERO)<0) {
            throw new BadRequestException(ErrorCodeEnum.AM0001.getMessage(),  ErrorCodeEnum.AM0001.getCode());
        }
    }

    public AcountEntity(String name, String taxNumber, String password, BigDecimal amount) {
        this.name = name;
        this.taxNumber = taxNumber;
        this.password = password;
        validateAmount(amount);
        this.amount = amount;
    }
}
