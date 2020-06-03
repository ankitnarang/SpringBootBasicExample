package myapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import myapi.model.Book;

@Service
public class BookService {
	
	private List<Book> bookList;
	public BookService() {
		bookList = new ArrayList<>();
		bookList.add(new Book("spring", "spring", "spring framework description"));
		bookList.add(new Book("Java", "Java 7", "It's all about Java 7 here"));
		bookList.add(new Book("javascript", "ES6", "It's all about ES6"));
		bookList.add(new Book("Angular JS", "Angular version 1", "It's all about Angular JS/ver 1"));
	}
	
	public List<Book> getAllBooks() {
		return bookList;
	}
	
	public Book getBook(String id) {
		return bookList.stream().filter(x -> x.getId().equalsIgnoreCase(id)).findFirst().get();
	}
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public void updateBook(String id, Book newBook) {
		for(int index = 0; index < bookList.size(); index++) {
			if(bookList.get(index).getId().equals(id)){
				bookList.set(index, newBook);
				return;
			}
		}
	}
	
	public void deleteBook(String id) {
		bookList.removeIf(x -> x.getId().equalsIgnoreCase(id));
	}

}
