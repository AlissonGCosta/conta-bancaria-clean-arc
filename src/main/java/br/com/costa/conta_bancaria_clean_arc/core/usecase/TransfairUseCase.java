package br.com.costa.conta_bancaria_clean_arc.core.usecase;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.TransfairInterface;

public class TransfairUseCase {

    private final TransfairInterface transfairInterface;

    public TransfairUseCase(TransfairInterface transfairInterface) {
        this.transfairInterface = transfairInterface;
    }

    public void TransfairUseCase(String txNumberToAcount, String txNumberFromAcount) {

        var toacount = transfairInterface.findByTaxNumber(txNumberToAcount)
               .orElseThrow();
        var fromacount = transfairInterface.findByTaxNumber(txNumberFromAcount)
               .orElseThrow();

        var toEntity =  transfairInterface.toEntity(toacount);
        var fromEntity =  transfairInterface.toEntity(fromacount);



        transfairInterface.transfairAmount(toAcount, fromAcount);
    }
}
