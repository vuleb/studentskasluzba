package me.fit.rest;


import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Zemlja;


@Path("/api/zemlja/")
public class ZemljaRest {

	@Inject
	@RestClient
	private ZemljaRestClient zemljaClient;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getZemlje")
	@Operation(summary = "Web servis koji vraca sve zemlje.", 
	description = "-")
	public Response getSveZemlje() {
		List <Zemlja> zemlje = zemljaClient.getAll();
		return Response.ok().entity(zemlje).build();
	}
}
