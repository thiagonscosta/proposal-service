package org.br.mineradora.service;

import java.util.Date;
import java.util.UUID;


import org.br.mineradora.dto.ProposalDetailsDto;
import org.br.mineradora.dto.ProposalDto;
import org.br.mineradora.entity.ProposalEntity;
import org.br.mineradora.message.KafkaEvent;
import org.br.mineradora.repository.ProposalRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ProposalServiceImpl implements ProposalService {

    @jakarta.inject.Inject 
    ProposalRepository proposalRepository;

    @Inject 
    KafkaEvent kafkaEvent;

    @Override
    public ProposalDetailsDto findFullProposal(UUID id) {
       ProposalEntity proposal = proposalRepository.findById(id);
       return ProposalDetailsDto.builder()
        .proposalId(proposal.getId())
        .proposalValidityDays(proposal.getProposalValidityDays())
        .country(proposal.getCountry())
        .priceTonne(proposal.getPriceTonne())
        .customer(proposal.getCustomer())
        .tonnes(proposal.getTonnes())
        .build();
    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDto data) {
        ProposalDto proposal = buildAndSaveNewProposal(data);
        kafkaEvent.sendNewKafkaEvent(proposal);
    }
    
    @Override
    @Transactional
    public void removeProposal(UUID id) {
       proposalRepository.deleteById(id);
    }

    @Transactional
    private ProposalDto buildAndSaveNewProposal(ProposalDetailsDto data) {
        try {
            ProposalEntity proposal = new ProposalEntity();
            proposal.setCreatedAt(new Date());
            proposal.setProposalValidityDays(data.getProposalValidityDays());
            proposal.setCountry(data.getCountry());
            proposal.setCustomer(data.getCustomer());
            proposal.setPriceTonne(data.getPriceTonne());
            proposal.setTonnes(data.getTonnes());

            proposalRepository.persist(proposal);

            return ProposalDto.builder()
                .proposalId(proposalRepository.findByCustomer(proposal.getCustomer()).get().getId())
                .priceTonne(proposal.getPriceTonne())
                .customer(proposal.getCustomer())
                .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
