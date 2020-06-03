package myapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import myapi.model.Book;
import myapi.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@RequestMapping("/books")
	public List<Book> getAllBooks(){
		return bookservice.getAllBooks();
	}
	
	@RequestMapping("/books/{id}")
	public Book getBook(@PathVariable String id){
		return bookservice.getBook(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/books")
	public void addBook(@RequestBody Book book) {
		System.out.println(book.getId() + " " + book.getName() + " " + book.getDescription());
		bookservice.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "/books/{id}")
	public void updateBook(@PathVariable String id,@RequestBody Book newBook) {
		bookservice.updateBook(id, newBook);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,path = "/books/{id}")
	public void deleteBook(@PathVariable String id) {
		bookservice.deleteBook(id);
	}
	
}
