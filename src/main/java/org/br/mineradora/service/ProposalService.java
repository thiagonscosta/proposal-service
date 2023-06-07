package org.br.mineradora.service;

import java.util.UUID;

import org.br.mineradora.dto.ProposalDetailsDto;
import org.br.mineradora.dto.ProposalDto;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProposalService {
    
    ProposalDetailsDto findFullProposal(UUID id);
    ProposalDto createNewProposal(ProposalDetailsDto data);
    void removeProposal(UUID id);
}
