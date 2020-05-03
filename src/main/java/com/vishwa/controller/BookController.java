package com.vishwa.controller;


import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vishwa.models.Book;
import com.vishwa.services.BookUtils;
import com.vishwa.services.interfaces.IBookService;

@RestController
@RequestMapping(path = "/book")
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@RequestMapping
	public  List<Book> getBooks() {
		Iterable<Book> allBooks = bookService.getAllBooks();
		return BookUtils.bookFilter(allBooks);
	}
	
	@RequestMapping("/count")
	public  long getBooksCount() {
		return bookService.getBooksCount();
	}
	
	@RequestMapping("/byid/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping("/byname/{name}")
	public List<Book> getBook(@PathVariable("name") String name) {
		return bookService.getBook(name);
	}
	
	@RequestMapping("/booknames")
	public List<String> getBookNames() {
		return bookService.getBookNames();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addBook(@RequestBody Book book) {
		book.setEntryDate(new Date().getTime());
		bookService.addBook(book);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/{noofbook}")
	public void addNoOfBook(@RequestBody Book book, @PathVariable("noofbook") String noofbook) {
		book.setEntryDate(new Date().getTime());
		bookService.addBook(book);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/byid/{id}")
	public void deleteBook(@PathParam("id") int id) {
		bookService.deleteBook(id);
	}
}
