package br.com.costa.conta_bancaria_clean_arc.core.gateway;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;

public interface CreateAcountInterface  {

    Boolean createAcount(AcountEntity account);
}
