package org.thibaut.thelibrary.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thiblibrary.ws.BookDtoJaxb;
import org.thibaut.thelibrary.webapp.client.ThelibraryClient;

import java.util.List;

@SpringBootApplication
//@EnableConfigurationProperties( ConfigProperties.class )
@ComponentScan(basePackages = {"org.thibaut.thelibrary"})
public class WebappApplication {

	public static void main( String[] args ) {
		SpringApplication.run( WebappApplication.class, args );
	}

	@Bean
	CommandLineRunner lookup( ThelibraryClient quoteClient ) {

//		String title = "Titre exemple";
//		GetBookResponse response = quoteClient.getBooks(title);
//
//		for ( Book book: response.getBook() ) {
//			System.out.println( "Book informations:" + book.getTitle() + " / " + book.getId() + " / " + book.getCategories() );
//		}

		return args -> {
			String title = "Book1";

			if (args.length > 0) {
				title = String.valueOf( args[0] );
			}

			List< BookDtoJaxb > response = quoteClient.getBook(title);

			for ( BookDtoJaxb book: response ) {
				System.out.println( "Book informations:" + book.getTitle() + " / " + book.getId() + " / " + book.getCategories() );
			}
		};
	}
}

