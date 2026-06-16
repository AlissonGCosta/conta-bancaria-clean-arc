package br.com.costa.conta_bancaria_clean_arc.usecase;

import br.com.costa.conta_bancaria_clean_arc.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.gateway.CreateAcountInterface;
import org.apache.catalina.User;

public class CreateAcount implements CreateAcountInterface {

    private AcountEntity account;

    public CreateAcount(AcountEntity account) {
        this.account = account;
    }

    @Override
    public Boolean createAcount(AcountEntity account) {

        if(account.getTaxNumber() == null){

            return false;
        }
        if(account.getPassword() == null){
            return false;
        }

        if(account.getAmount() == null){
            return false;
        }


        return  true;
    }
}
