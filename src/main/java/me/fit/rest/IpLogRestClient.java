package me.fit.rest;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.model.IPlog;

@Path("/data")
@RegisterRestClient
public interface IpLogRestClient {

	@GET
	@Path("/client-ip")
	IPlog getAll();
}
