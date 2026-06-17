package br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AcountRequest {
    private String name;
    private String taxNumber;
    private String password;
    private BigDecimal amount;
}
