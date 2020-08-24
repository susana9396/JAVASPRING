package cl.inacap.jpa.controllers;

import java.util.List;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cl.inacap.jpa.models.Book;
import cl.inacap.jpa.service.BooksService;

@RestController
public class BooksApi {
	
	    private final BooksService booksService;
	    public BooksApi(BooksService booksService){
	        this.booksService = booksService;
	    }
	    @RequestMapping("/api/books")
	    public List<Book> index() {
	        return booksService.allBooks();
	    }
	    
	    @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public Book create(
	    	@RequestParam(value="title") String title, 
	    	@RequestParam(value="description") String desc, 
	    	@RequestParam(value="language") String lang, 
	    	@RequestParam(value="pages") Integer numOfPages
	    ) {
	        Book book = new Book(title, desc, lang, numOfPages);
	        return booksService.createBook(book);
	    }
	    
	    @RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) {
	        Book book = booksService.findBook(id);
	        return book;
	    }
	
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public Book update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages
	    ) {
	        Book book = booksService.updateBook(id, title, desc, lang, numOfPages);
	        return book;
	    }
	    
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	        booksService.deleteBook(id);
	    }
	
}
