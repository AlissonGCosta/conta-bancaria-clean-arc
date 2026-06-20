package br.com.costa.conta_bancaria_clean_arc.core.gateway;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.AcountJpaEntity;


import java.util.Optional;

public interface TransfairInterface {

    void transfairAmount(AcountEntity toAccount, AcountEntity fromAccount);
    Optional<AcountJpaEntity> findByTaxNumber(String taxNumber);
    AcountEntity toEntity(AcountJpaEntity entity);
}
