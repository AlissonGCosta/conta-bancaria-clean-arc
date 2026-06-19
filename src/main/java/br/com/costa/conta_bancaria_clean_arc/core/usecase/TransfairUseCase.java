package br.com.costa.conta_bancaria_clean_arc.core.usecase;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.BadRequestException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.ConflictException;
import br.com.costa.conta_bancaria_clean_arc.core.domain.exceptions.enums.ErrorCodeEnum;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.TransfairInterface;

import java.math.BigDecimal;

public class TransfairUseCase {

    private final TransfairInterface transfairInterface;

    public TransfairUseCase(TransfairInterface transfairInterface) {
        this.transfairInterface = transfairInterface;
    }

    public void TransfairUseCase(String txNumberToAcount, String txNumberFromAcount, BigDecimal amount) {

        var toacount = transfairInterface.findByTaxNumber(txNumberToAcount)
               .orElseThrow();
        var fromacount = transfairInterface.findByTaxNumber(txNumberFromAcount)
               .orElseThrow();

        var toEntity =  transfairInterface.toEntity(toacount);
        var fromEntity =  transfairInterface.toEntity(fromacount);

        if (toEntity.equals(fromEntity) || fromEntity.equals(toacount)) {
            throw new ConflictException(ErrorCodeEnum.TRA001.getMessage(),  ErrorCodeEnum.TRA001.getCode());
        }

        if (amount == null||amount.compareTo(BigDecimal.ZERO)<0) {
            throw new BadRequestException(ErrorCodeEnum.TRA002.getMessage(),  ErrorCodeEnum.TRA002.getCode());
        }

         fromacount.getAmount().subtract(amount);
         toacount.getAmount().add(amount);


        transfairInterface.transfairAmount(fromEntity, toEntity );
    }
}
