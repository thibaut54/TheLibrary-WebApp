package org.thibaut.thelibrary.webapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thiblibrary.ws.BookDtoJaxb;
import org.thiblibrary.ws.GetBookRequest;
import org.thiblibrary.ws.ObjectFactory;
import org.thiblibrary.ws.ThelibraryPort;

import java.util.List;

@Component
public class ThelibraryClient {

	@Autowired
	private ThelibraryPort thelibraryProxy;

	public List< BookDtoJaxb > getBook( String title){

		BookDtoJaxb bookDto = new ObjectFactory().createBookDtoJaxb();

		GetBookRequest bookRequest = new ObjectFactory().createGetBookRequest();
		bookRequest.setBookTitle( title );

		return thelibraryProxy.getBook( bookRequest ).getBook();
	}
}
