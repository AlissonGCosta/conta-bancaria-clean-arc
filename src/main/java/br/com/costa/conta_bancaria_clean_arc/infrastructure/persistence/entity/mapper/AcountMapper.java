package br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.AcountJpaEntity;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.Response.AcountResponse;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.dto.request.AcountRequest;

public class AcountMapper {

    public AcountJpaEntity toJpaEntity(AcountEntity account) {
        return new AcountJpaEntity(account.getId(),
                account.getName(),
                account.getTaxNumber(),
                account.getPassword(),
                account.getAmount());
    }

    public AcountResponse toResponseEntity(AcountRequest accountRequest) {
        return new AcountResponse(
                accountRequest.getName(),
                accountRequest.getTaxNumber(),
                accountRequest.getPassword(),
                accountRequest.getAmount()
        );
    }

   public AcountEntity toEntity(AcountRequest accountRequest) {
        return new AcountEntity(
                accountRequest.getName(),
                accountRequest.getTaxNumber(),
                accountRequest.getPassword(),
                accountRequest.getAmount()
        );
   }


}
