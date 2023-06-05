package org.br.mineradora.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class ProposalDto {

    private UUID proposalId;

    private String customer;

    private BigDecimal priceTonne;
}   
