package com.camel.rest.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camel.rest.model.Customer;

/**
 * @author Tuhin Gupta
 *
 */
public class CustomerProcessor implements Processor {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	 
	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("Customer Processor: "+exchange.getIn().getHeaders());
		
		List<Customer> customerList = new ArrayList<>();
		
		customerList.add(new Customer("CustA","address a", "US-A"));
		customerList.add(new Customer("CustB","address B", "US-B"));
		
		exchange.getOut().setBody(customerList);
		
	}
}
