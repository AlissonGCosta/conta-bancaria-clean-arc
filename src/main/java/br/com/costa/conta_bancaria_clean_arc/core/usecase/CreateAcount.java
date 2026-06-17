package br.com.costa.conta_bancaria_clean_arc.core.usecase;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;


public class CreateAcount  {

    private final CreateAcountInterface createAcountInterface;


    public CreateAcount(CreateAcountInterface createAcountInterface) {
        this.createAcountInterface = createAcountInterface;
    }

    public Boolean createAcount(AcountEntity account) {
        return createAcountInterface.createAcount(account);
    }
}
