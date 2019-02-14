package org.thibaut.thelibrary.webapp.client;

import hello.wsdl.GetBookRequest;
import hello.wsdl.GetBookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BookClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(BookClient.class);

	public GetBookResponse getBook( Integer id ) {

		GetBookRequest request = new GetBookRequest();
		request.setId(id);

		log.info("Requesting book for ID: " + id);

		GetBookResponse response = (GetBookResponse) getWebServiceTemplate()
				                                                   .marshalSendAndReceive("http://localhost:8080/ws/books", request,
						                                                   new SoapActionCallback(
								                                                   "http://spring.io/guides/gs-producing-web-service/GetBookRequest"));

		return response;
	}
}
