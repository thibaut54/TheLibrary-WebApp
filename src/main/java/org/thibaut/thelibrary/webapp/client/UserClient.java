package org.thibaut.thelibrary.webapp.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import thelibrary.wsdl.GetUserRequest;
import thelibrary.wsdl.GetUserResponse;

@Component
public class UserClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(UserClient.class);

	public GetUserResponse getUserByEmail( String email ) {

		GetUserRequest request = new GetUserRequest();

		request.setEmail(email);

		log.info("Requesting user for email: " + email);

		GetUserResponse response =
				(GetUserResponse ) getWebServiceTemplate().marshalSendAndReceive(
						                                                "http://localhost:8080/ws",
						                                                        request,
						new SoapActionCallback( "http://spring.io/guides/gs-producing-web-service/GetBookRequest" ));

		return response;
	}

	public GetUserResponse getUserByUsername( String username ) {

		GetUserRequest request = new GetUserRequest();

		request.setUserName(username);

		log.info("Requesting user for username: " + username);

		GetUserResponse response = (GetUserResponse ) getWebServiceTemplate()
				                                              .marshalSendAndReceive(
						                                              "http://localhost:8080/ws",
						                                              request,
						                                              new SoapActionCallback( "http://spring.io/guides/gs-producing-web-service/GetBookRequest" ));

		return response;
	}
}
