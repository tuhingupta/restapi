package com.camel.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface QController {
	
	@POST
	@Path("/{messageId}")
	@Consumes("application/json")
	public Response getMessage(@PathParam("messageId") String messageId);

}
