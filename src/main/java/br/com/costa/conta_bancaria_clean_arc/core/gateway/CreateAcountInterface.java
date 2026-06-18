package br.com.costa.conta_bancaria_clean_arc.core.gateway;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;

public interface CreateAcountInterface  {

    void createAcount(AcountEntity account);
    Boolean existsByTaxNumber(String taxNumber);
}
