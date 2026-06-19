package br.com.costa.conta_bancaria_clean_arc.infrastructure.dataprovider;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.TransfairInterface;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.AcountJpaEntity;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper.AcountMapper;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.repository.AcountJpaEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransfairImpl implements TransfairInterface {

    private final AcountJpaEntityRepository repository;
    private final AcountMapper mapper;

    @Override
    public void transfairAmount(AcountEntity toAccount, AcountEntity fromAccount) {

        repository.save(mapper.toJpaEntity(toAccount));
        repository.save(mapper.toJpaEntity(fromAccount));

    }

    public Optional<AcountJpaEntity> findByTaxNumber(String taxNumber) {
       return repository.findByTaxNumber(taxNumber);

    }

    public AcountEntity toEntity(AcountJpaEntity entity) {
        return mapper.toEntity(entity);
    }


}
