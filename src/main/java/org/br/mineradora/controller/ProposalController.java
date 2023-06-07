package org.br.mineradora.controller;

import java.util.UUID;

import org.br.mineradora.dto.ProposalDetailsDto;
import org.br.mineradora.dto.ProposalDto;
import org.br.mineradora.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    public ProposalDetailsDto findDetailsProposal(@PathParam("id") UUID id) {
        return proposalService.findFullProposal(id);
    }

    @POST
    public Response createProposal(ProposalDetailsDto data) {
        try {
            ProposalDto response = proposalService.createNewProposal(data);
            return Response.ok().entity(response).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeProposal(@PathParam("id") UUID id) {
        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
