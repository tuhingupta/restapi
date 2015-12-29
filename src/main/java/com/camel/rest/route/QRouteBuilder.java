package com.camel.rest.route;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Tuhin Gupta
 *
 */
@Component
public class QRouteBuilder extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		
		onException(Exception.class)
        .log( "Q ERROR==> header ${header.CamelHttpPath}, body: ${body}")
        .to("log:GeneralError?level=ERROR")
        //.to("jms:queue:failedQ");
        ;
        
	 /*
	  * A typical UC for this route would be, a REST request is received
	  * and a received response is sent immediately. 
	  * While the processing of the message is done asynchronously using activemq queue.
	  */
        from("cxfrs:bean:qAPI").routeId("qAPIRoute")
            .process(new Processor(){
            	@Override
            	public void process(Exchange exchange) throws Exception {
            		
            		String input = exchange.getIn().getBody().toString();
            		System.out.println("qAPI Processor"+input);
            		
            		exchange.getOut().setBody(input);
            		
            		
            	}
            })
            .wireTap("jms:topic:incomingReq") //this is async. 
            .beanRef("qBean","respond")
           
        ;
		
		
		
	}

}
