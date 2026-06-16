package br.com.costa.conta_bancaria_clean_arc.domain.entitys;

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
        this.amount = amount;
    }

    public AcountEntity(String name, String taxNumber, String password, BigDecimal amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.taxNumber = taxNumber;
        this.password = password;
        this.amount = amount;
    }
}
