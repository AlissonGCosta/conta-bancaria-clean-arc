package br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.AcountJpaEntity;

public class AcountMapper {

    public AcountJpaEntity toJpaEntity(AcountEntity account) {
        return new AcountJpaEntity(account.getId(),
                account.getName(),
                account.getTaxNumber(),
                account.getPassword(),
                account.getAmount());
    }
}
