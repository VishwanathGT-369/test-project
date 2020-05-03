package com.vishwa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwa.enums.BookStatus;
import com.vishwa.models.Book;
import com.vishwa.repository.BookRepository;
import com.vishwa.services.interfaces.IBookService;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public  Iterable<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	@Override
	public  long getBooksCount() {
		return bookRepo.count();
	}

	@Override
	public Book getBook(int id) {
		return bookRepo.findById(id).orElse(null);
	}

	@Override
	public List<Book> getBook(String name) {
		return null;
	}

	@Override
	public void addBook(Book book) {
		bookRepo.save(book);
		
	}

	@Override
	public void deleteBook(int id) {
		Book book = this.getBook(id);
		book.setStatus(BookStatus.DELETED);
		bookRepo.save(book);
	}

	@Override
	public void deleteBook(String name) {
		
	}

	@Override
	public List<String> getBookNames() {
		return bookRepo.getBookNames();
	}
	
}
