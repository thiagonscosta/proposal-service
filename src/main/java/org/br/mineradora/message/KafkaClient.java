package org.br.mineradora.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaClient {

    private final Logger LOG = LoggerFactory.getLogger(KafkaClient.class);

    @Channel("proposal")
    Emitter<ProposalDto> proposalRequestEmiter; 

    public void sendNewKafkaEvent(ProposalDto proposalDto) {
        LOG.info("Enviando nova proposta para tópico kafka");

        proposalRequestEmiter.send(proposalDto)
    }
     
}
