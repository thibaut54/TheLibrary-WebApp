//package org.thibaut.thelibrary.webapp.client;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//import org.springframework.ws.soap.client.core.SoapActionCallback;
//import org.thibaut.thelibrary.webapp.constant.SoapProperties;
//import thelibrary.wsdl.GetUserRequest;
//import thelibrary.wsdl.GetUserResponse;
//
//import javax.xml.bind.annotation.XmlSeeAlso;
//
//@Component
////@XmlSeeAlso( { RoleDtoJaxb.class } )
//public class UserClient extends WebServiceGatewaySupport {
//
//	private static final Logger log = LoggerFactory.getLogger(UserClient.class);
//
//
//	public GetUserResponse getUserByEmail( String email ) {
//
//		GetUserRequest request = new GetUserRequest();
//
//		request.setEmail(email);
//
//		log.info("Requesting user for email: " + email);
//
//		return (GetUserResponse ) getWebServiceTemplate().marshalSendAndReceive(request);
//	}
//
//
//	public GetUserResponse getUserByUsername( String username ) {
//
//		GetUserRequest request = new GetUserRequest();
//
//		request.setUserName(username);
//
//		log.info("Requesting user for username: " + username);
//
//		return (GetUserResponse ) getWebServiceTemplate().marshalSendAndReceive(
//				SoapProperties.WS_URI,
//				request,
//				new SoapActionCallback( SoapProperties.TARGET_NAME_SPACE));
//
////		return (GetUserResponse ) getWebServiceTemplate().marshalSendAndReceive(URI, request);
//
////		return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);
//	}
//}
