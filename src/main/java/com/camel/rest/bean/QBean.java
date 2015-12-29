package com.camel.rest.bean;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;

/**
 * @author Tuhin Gupta
 *
 */
public class QBean {
	
	
	public void getMessage(Exchange exchange, String body) 
	{
		System.out.println("***Q Message:- "+exchange.getExchangeId()+" "+body);
		exchange.getOut().setBody(body);
	}
	
	public void respond(Exchange exchange, String body){
		
		System.out.println("***Q Message:- "+exchange.getExchangeId()+" "+body);

		Response r = Response.status(201).build();
        exchange.getOut().setBody(r);
		
	}

}
