package com.camel.rest.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Tuhin Gupta
 *
 */
@Component
public class QConsumeRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		

		from("jms:topic:incomingReq")
		.process(new Processor(){
			@Override
			public void process(Exchange exchange) throws Exception {
				System.out.println("==**== "+exchange.getIn().getBody().toString());
				
				
			}
		})
	;
		
	}
}
