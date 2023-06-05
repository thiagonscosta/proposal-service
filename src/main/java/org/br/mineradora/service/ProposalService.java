package org.br.mineradora.service;

import java.util.UUID;

import org.br.mineradora.dto.ProposalDetailsDto;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProposalService {
    
    ProposalDetailsDto findFullProposal(UUID id);
    void createNewProposal(ProposalDetailsDto data);
    void removeProposal(UUID id);
}
