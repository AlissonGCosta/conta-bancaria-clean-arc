package br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.repository;

import br.com.costa.conta_bancaria_clean_arc.infrastructure.persistence.entity.AcountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AcountJpaEntityRepository extends JpaRepository<AcountJpaEntity, UUID> {

    boolean existsByTaxNumber(String taxNumber);
    Optional<AcountJpaEntity> findByTaxNumber(String taxNumber);

}
