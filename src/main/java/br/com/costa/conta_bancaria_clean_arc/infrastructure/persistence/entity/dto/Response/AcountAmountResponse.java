package br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.Response;

import java.math.BigDecimal;

public record AcountAmountResponse(

         BigDecimal amount
) {
}
