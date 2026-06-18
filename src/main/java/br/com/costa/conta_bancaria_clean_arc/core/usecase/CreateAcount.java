package br.com.costa.conta_bancaria_clean_arc.core.usecase;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.ConflictException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.enums.ErrorCodeEnum;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;


public class CreateAcount  {

    private final CreateAcountInterface createAcountInterface;



    public CreateAcount(CreateAcountInterface createAcountInterface) {
        this.createAcountInterface = createAcountInterface;

    }

    public void createAcount(AcountEntity account) {

        if(createAcountInterface.existsByTaxNumber(account.getTaxNumber())){
            throw new ConflictException(ErrorCodeEnum.ON0002.getMessage(),  ErrorCodeEnum.ON0002.getCode());
        }
       createAcountInterface.createAcount(account);

    }
}
