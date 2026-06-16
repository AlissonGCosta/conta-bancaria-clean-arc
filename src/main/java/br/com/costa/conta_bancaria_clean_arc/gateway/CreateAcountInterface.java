package br.com.costa.conta_bancaria_clean_arc.gateway;

import br.com.costa.conta_bancaria_clean_arc.domain.entitys.AcountEntity;
import org.apache.catalina.User;

public interface CreateAcountInterface {

    Boolean createAcount(AcountEntity account);
}
