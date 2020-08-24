package cl.inacap.jpa.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.inacap.jpa.models.Book;
import cl.inacap.jpa.service.BooksService;

@Controller
public class BooksController {

	private final BooksService bookService;
	
	public BooksController(BooksService bookService) {
		this.bookService=bookService;
	}
	/// Listado de libros
	@RequestMapping("/books")
	public String index (Model m) {
		List<Book> mbooks=bookService.allBooks();
		m.addAttribute("books", mbooks);
		
		return "/WEB-INF/libros/index.jsp";
	}
	///Ir al formulario para ingresar nuevo libro
	@RequestMapping("/books/new")
	public String nbook(@ModelAttribute("book") Book book) {
		return "/WEB-INF/libros/new.jsp";
	}
	
	///Crear un nuevo registro usando metodo POST (El método POST se utiliza para enviar una entidad a un recurso en específico)
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if (result.hasErrors()) {
			return "/WEB-INF/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	///Ver libros usando método GET (Las peticiones que usan el método GET sólo deben recuperar datos)
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Long id, Model m) {
		
		Book libro=bookService.findBook(id);
		if (libro==null) {
			return "redirect:/books/new";
		} else {
			m.addAttribute("books", libro);
			return "/WEB-INF/libros/show.jsp";
		}
	}
	///Editar
	@RequestMapping("/books/{id}/edit")
	public String editar (@PathVariable("id") Long id, Model m) {
		Book book=bookService.findBook(id);
		m.addAttribute("books", book);	
		return "/WEB-INF/libros/edit.jsp";
	}
	///Actualizar utilizando  methodo put (Reemplaza las representaciones actuales del recurso de destino con la carga útil de la petición.)
	@RequestMapping(value="/books/{id}/update" ,  method = RequestMethod.PUT)
	public String up (@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "/WEB-INF/libros/edit.jsp";
		}else {
		bookService.updateBook(book);
		return "redirect:/books";
	}
	}
	///Borra  libro utilizando DELETE (El método DELETE borra un recurso en específico)
	@RequestMapping(value="/books/{id}/delete", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}