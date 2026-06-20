package br.com.costa.conta_bancaria_clean_arc.core.usecase;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.BadRequestException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.ConflictException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.NotFoundException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.enums.ErrorCodeEnum;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.TransfairInterface;

import java.math.BigDecimal;

public class TransfairUseCase {

    // chamando a interface
    private final TransfairInterface transfairInterface;

    public TransfairUseCase(TransfairInterface transfairInterface) {
        this.transfairInterface = transfairInterface;
    }


    //metodo para transferencia

    public void transfairUseCase(String txNumberToAccount, String txNumberFromAccount, BigDecimal amount) {


        // buscando no repositorio
        var fromAccount = transfairInterface.findByTaxNumber(txNumberFromAccount)
               .orElseThrow(
                       ()-> new NotFoundException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode())
               );

        var toAccount = transfairInterface.findByTaxNumber(txNumberToAccount)
               .orElseThrow(
                       ()-> new NotFoundException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode())
               );

        // comparando os inputs
        if (fromAccount.equals(toAccount) || toAccount.equals(fromAccount)) {
            throw new ConflictException(ErrorCodeEnum.TRA001.getMessage(),  ErrorCodeEnum.TRA001.getCode());
        }

        var toEntity =  transfairInterface.toEntity(toAccount);
        var fromEntity =  transfairInterface.toEntity(fromAccount);

        // comparando as entidades
        if (toEntity.equals(fromEntity) || fromEntity.equals(toEntity)) {
            throw new ConflictException(ErrorCodeEnum.TRA001.getMessage(),  ErrorCodeEnum.TRA001.getCode());
        }

        // fazendo a ação de adcionar e subtrair
         toEntity.setAmount(toEntity.getAmount().subtract(amount));
         fromEntity.setAmount(fromEntity.getAmount().add(amount));


        transfairInterface.transfairAmount(fromEntity, toEntity);
    }
}
