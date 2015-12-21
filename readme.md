restapi Project
====================

This project uses Camel CXF REST API and Active MQ.
You will see code to GET and POST message to REST APIs.
When a message is posted to REST API, it is also sent to Active MQ topic.

To build this project:

$mvn clean install

To run this project:
This project can be deployed as a war file in JBOSS EAP 6.x (I tested with JBOSS EAP 6.4)
Just drop the war file into deployments directory   

Endpoint to try out:

HTTP 1.1/POST http://localhost:8080/restapi/v1/customer/{id}
Sample Payload:
{
"Customer":{
    "name": "Cust-A",
    "address": "address a",
    "country": "US-A"
  }
}


HTTP 1.1/GET http://localhost:8080/restapi/v1/customer/{id}

HTTP 1.1/POST http://localhost:8080/restapi/v1/message/{id}