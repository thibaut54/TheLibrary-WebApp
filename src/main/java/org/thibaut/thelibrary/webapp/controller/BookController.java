package org.thibaut.thelibrary.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thibaut.thelibrary.webapp.client.BookClient;
import thelibrary.wsdl.GetBookResponse;

@Controller
public class BookController {

	@Autowired
	private BookClient bookClient;


	@GetMapping("/user/bookTitle")
	public String bookTitle( Model model ){
		GetBookResponse books = bookClient.getBooks( "Book1" );
		System.out.println( " BOOK LIST " );
		books.getBook().forEach( book -> System.out.println( book.getTitle() ));
		return "test";
	}

}
