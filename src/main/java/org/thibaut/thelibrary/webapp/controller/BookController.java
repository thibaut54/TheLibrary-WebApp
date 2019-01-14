package org.thibaut.thelibrary.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
import org.thibaut.thelibrary.webapp.generated.cxf.searchbook.SearchBookService;

@Controller
public class BookController {

	@Autowired
	SearchBookService searchBookService;

	@Autowired
	RepositoryFactory repositoryFactory;

	@GetMapping("/bookTitle")
	public String bookTitle( Model model ){
		Integer id = repositoryFactory.getBookRepository().findAll().get( 0 ).getId();
		System.out.println(  searchBookService.getBookTitle(id) );
		return searchBookService.getBookTitle(id);
	}

}
