package org.br.mineradora.repository;

import java.util.Optional;
import java.util.UUID;

import org.br.mineradora.entity.ProposalEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProposalRepository implements PanacheRepositoryBase<ProposalEntity, UUID> {

    public Optional<ProposalEntity> findByCustomer(String customer) {
        return Optional.of(find("customer", customer).firstResult());
    } 
}