package br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AcountRequestAmount {
    private BigDecimal amount;
}
