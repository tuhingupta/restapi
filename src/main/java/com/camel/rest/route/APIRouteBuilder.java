package com.camel.rest.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Tuhin Gupta
 *
 */
@Component
public class APIRouteBuilder extends RouteBuilder{
	
	 @Override
	    public void configure() throws Exception {

	        
	        onException(Exception.class)
	        .log( "ERROR==> header ${header.CamelHttpPath}, body: ${body}")
	        .to("log:GeneralError?level=ERROR")
	        //.to("jms:queue:failedQ");
	        ;
	        
		 
	        from("cxfrs:bean:rsServer").routeId("customerAPI")
	            .log( "==> header ${header.CamelHttpPath}, body: ${body}, operation name: ${header.operationName}")
	           // .process(new CustomerProcessor()) 
	           // you could use a bean or a process for processing the response
	            .choice()
	            	.when(header("operationName").isEqualTo("getCustomer"))
	            		.beanRef("customerBean", "getCustomers")
	            	.when(header("operationName").isEqualTo("addCustomer"))
	            		.beanRef("customerBean", "addCustomer")
	            ;
	 }

}

