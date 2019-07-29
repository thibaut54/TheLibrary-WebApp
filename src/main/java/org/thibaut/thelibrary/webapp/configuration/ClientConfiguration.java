//package org.thibaut.thelibrary.webapp.configuration;
//
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.thibaut.thelibrary.webapp.client.BookClient;
//import org.thibaut.thelibrary.webapp.client.UserClient;
//import org.thibaut.thelibrary.webapp.constant.SoapProperties;
//
//import javax.annotation.PostConstruct;
//
//@Configuration
//@AllArgsConstructor
//public class ClientConfiguration {
//
//
//	@Bean
//	public Jaxb2Marshaller marshaller() {
//		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//		// this package must match the package in the <generatePackage> specified in
//		// pom.xml
//		marshaller.setContextPath(SoapProperties.WSDL_FILE);
//		return marshaller;
//	}
//
//
//	@Bean
//	public BookClient bookClient(Jaxb2Marshaller marshaller) {
//		BookClient client = new BookClient();
//		client.setDefaultUri(SoapProperties.WSDL_URI);
//		client.setMarshaller(marshaller);
//		client.setUnmarshaller(marshaller);
//		return client;
//	}
//
//
//	@Bean
//	public UserClient userClient( Jaxb2Marshaller marshaller) {
//		UserClient client = new UserClient();
//		client.setDefaultUri(SoapProperties.WSDL_URI);
//		client.setMarshaller(marshaller);
//		client.setUnmarshaller(marshaller);
//		return client;
//	}
//
//}
