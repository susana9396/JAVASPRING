package cl.inacap.jpa.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.inacap.jpa.models.Book;
import cl.inacap.jpa.repositories.BookRepository;


@Service
public class BooksService {
    //Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;
    
    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = findBook(id);
		if(book == null) {
			return null;
		}
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		return bookRepository.save(book);
	}
	public void deleteBook(Long id) {
		Book book = findBook(id);
		if(book == null) {
			return;
		}
		bookRepository.deleteById(id);
	}
}