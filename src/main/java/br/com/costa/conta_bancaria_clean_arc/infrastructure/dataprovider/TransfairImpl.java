package br.com.costa.conta_bancaria_clean_arc.infrastructure.dataprovider;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.TransfairInterface;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.AcountJpaEntity;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper.AcountMapper;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.repository.AcountJpaEntityRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TransfairImpl implements TransfairInterface {

    private final AcountJpaEntityRepository repository;
    private final AcountMapper mapper;

    @Override
    public void transfairAmount(String toAccount, String fromAccount) {

        repository.save();
        repository.save();

    }

    public Optional<AcountJpaEntity> findByTaxNumber(String taxNumber) {
       return repository.findByTaxNumber(taxNumber);

    }

    public AcountEntity toEntity(AcountJpaEntity entity) {
        return mapper.toEntity(entity);
    }


}
