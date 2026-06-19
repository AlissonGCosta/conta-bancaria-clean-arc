package br.com.costa.conta_bancaria_clean_arc.infrastructure.config;

import br.com.costa.conta_bancaria_clean_arc.core.domain.entitys.AcountEntity;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.CreateAcountInterface;
import br.com.costa.conta_bancaria_clean_arc.core.gateway.TransfairInterface;
import br.com.costa.conta_bancaria_clean_arc.core.usecase.CreateAcount;
import br.com.costa.conta_bancaria_clean_arc.core.usecase.TransfairUseCase;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.dataprovider.CreateAcountImp;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.mapper.AcountMapper;
import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.repository.AcountJpaEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcountConfig {

    @Bean
    public CreateAcount createAcount(CreateAcountInterface createAcountInterface) {
        return new CreateAcount(createAcountInterface);
    }

    @Bean
    public AcountMapper acountMapper() {
        return new AcountMapper();
    }

    @Bean
    public TransfairUseCase transfairUseCase(TransfairInterface transfairInterface) {
        return  new TransfairUseCase(transfairInterface);
    }
}
