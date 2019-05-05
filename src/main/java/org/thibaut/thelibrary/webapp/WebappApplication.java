package org.thibaut.thelibrary.webapp;

import thelibrary.wsdl.Book;
import thelibrary.wsdl.GetBookResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thibaut.thelibrary.webapp.client.BookClient;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.thibaut.thelibrary"})
public class WebappApplication {

	public static void main( String[] args ) {
		SpringApplication.run( WebappApplication.class, args );
	}

	@Bean
	CommandLineRunner lookup( BookClient quoteClient ) {

		return args -> {
			String title = "Book";

			if (args.length > 0) {
				title = String.valueOf( args[0] );
			}

			GetBookResponse response = quoteClient.getBooks(title);

			for ( Book book: response.getBook() ) {
				System.out.println( "Book informations:" + book.getTitle() + " / " + book.getId() + " / " + book.getCategories() );
			}
		};
	}
}

