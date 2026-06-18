package br.com.costa.conta_bancaria_clean_arc.infrastructure.dataprovider;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper.AcountMapper;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.repository.AcountJpaEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAcountImp implements CreateAcountInterface {

    private final AcountJpaEntityRepository repository;
    private final AcountMapper mapper;


    @Override
    public void createAcount(AcountEntity account) {
        repository.save(mapper.toJpaEntity(account));

    }

    @Override
    public Boolean existsByTaxNumber(String taxNumber) {
        return repository.existsByTaxNumber(taxNumber);
    }
}
