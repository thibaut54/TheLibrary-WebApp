package org.thibaut.thelibrary.webapp.client;

import org.springframework.stereotype.Component;
import thelibrary.wsdl.GetBookRequest;
import thelibrary.wsdl.GetBookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class BookClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(BookClient.class);

	public GetBookResponse getBooks( String title ) {

		GetBookRequest request = new GetBookRequest();

		request.setBookTitle(title);

		log.info("Requesting book for title: " + title);

		GetBookResponse response = (GetBookResponse) getWebServiceTemplate()
				                                                   .marshalSendAndReceive(
//				                                                   		"http://localhost:8080/ws/books",
						                                                   request/*,
						                                                   new SoapActionCallback( "http://spring.io/guides/gs-producing-web-service/GetBookRequest" )*/);

		return response;
	}
}
