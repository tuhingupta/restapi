package com.camel.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.camel.rest.model.Customer;



/**
 * @author Tuhin Gupta
 *
 */
public interface CustomerController {
	
	//
	
	@GET
	@Path("/{customerId}")
	@Produces("application/json")
	public Response getCustomer(@PathParam("customerId") String customerId);
	
	@POST
	@Path("/{customerId}")
	@Consumes("application/json")
	public Response addCustomer(@PathParam("customerId") String customerId, Customer customer);

}
