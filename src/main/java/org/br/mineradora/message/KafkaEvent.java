package org.br.mineradora.message;

import org.br.mineradora.dto.ProposalDto;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    // @Channel("proposal")
    // Emitter<ProposalDto> proposalRequestEmiter; 

    // public void sendNewKafkaEvent(ProposalDto proposalDto) {
    //     LOG.info("Enviando nova proposta para tópico kafka");
    //     proposalRequestEmiter.send(proposalDto).toCompletableFuture().join();
    // }
     
}
