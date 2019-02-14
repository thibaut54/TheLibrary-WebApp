package org.thibaut.thelibrary.webapp;

import hello.wsdl.GetBookResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
			Integer id = 59;

			if (args.length > 0) {
				id = Integer.valueOf( args[0] );
			}
			GetBookResponse response = quoteClient.getBook(id);
			System.err.println(response.getBook().getTitle());
		};
	}
}

