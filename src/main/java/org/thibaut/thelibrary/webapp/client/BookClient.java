//package org.thibaut.thelibrary.webapp.client;
//
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//import org.springframework.ws.soap.client.core.SoapActionCallback;
//import thelibrary.wsdl.GetBookRequest;
//import thelibrary.wsdl.GetBookResponse;
//
//@Component
//@Slf4j
//public class BookClient extends WebServiceGatewaySupport {
//
//
//	public GetBookResponse getBooks( String title ) {
//
//		GetBookRequest request = new GetBookRequest();
//
//		request.setBookTitle(title);
//
//		log.info("Requesting book for title: " + title);
//
//		return (GetBookResponse) getWebServiceTemplate().marshalSendAndReceive(request);
//	}
//}
