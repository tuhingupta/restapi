package com.camel.rest.api.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.cxf.message.MessageContentsList;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tuhin Gupta
 *
 */
public class RouteBuilderTest  extends CamelSpringTestSupport{
	
	/*
	 * Test CustomerController route - APIRouteBuilder
	 * from("cxfrs:bean:rsServer")
	            .log( "==> header ${header.CamelHttpPath}, body: ${body}, operation name: ${header.operationName}")
	           // .process(new CustomerProcessor()) 
	           // you could use a bean or a process for processing the response
	            .choice()
	            	.when(header("operationName").isEqualTo("getCustomer"))
	            		.beanRef("customerBean", "getCustomers")
	            	.when(header("operationName").isEqualTo("addCustomer"))
	            		.beanRef("customerBean", "addCustomer")
	            ;
	 */

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				new String[]{"camel/camel-context.xml"});
	}
	
	@Test
	public void testCustomerAPIRoute() throws Exception{
		
		context.getRouteDefinition("customerAPI").adviceWith(context, new AdviceWithRouteBuilder() {
			
			
			@Override
			public void configure() throws Exception {
				
				replaceFromWith("direct:start");
				
				
			}
		});
		
		MessageContentsList message = new MessageContentsList();
		message.add("12345");
		Map<String, Object> queryData = new HashMap<>();
		queryData.put("operationName", "getCustomers");
		
		Map map = new HashMap<>();
		map.put("jaxrs.template.parameters", new HashMap<>());
		queryData.put("CamelCXFMessage", map);
		queryData.put(Exchange.HTTP_URI, "/v1/customer/98765");
		
		MessageContentsList response = (MessageContentsList) template.requestBodyAndHeaders("direct:start", message, queryData);
		//assertEquals(201, response.getStatus());
		System.out.println(response);
		
		
	}
	
	
	
	
}
