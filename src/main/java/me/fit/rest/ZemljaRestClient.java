package me.fit.rest;
	
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.model.Zemlja;


@Path("/api/test")
@RegisterRestClient

public interface ZemljaRestClient {

	@GET
	@Path("/dostupneZemlje")
    List<Zemlja> getAll();
}
