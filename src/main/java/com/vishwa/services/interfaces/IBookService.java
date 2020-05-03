package com.vishwa.services.interfaces;

import java.util.List;

import com.vishwa.models.Book;

public interface IBookService {

	public Iterable<Book> getAllBooks();
	public Book getBook(int id);
	public List<Book> getBook(String name);
	public void addBook(Book book);
	public void deleteBook(int id);
	public void deleteBook(String name);
	public long getBooksCount();
	public List<String> getBookNames();
}
