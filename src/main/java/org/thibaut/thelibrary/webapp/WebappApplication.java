package org.thibaut.thelibrary.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.thibaut.thelibrary"})
public class WebappApplication {

	public static void main( String[] args ) {
		SpringApplication.run( WebappApplication.class, args );
	}

}

