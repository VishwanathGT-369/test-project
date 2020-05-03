package com.vishwa.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vishwa.enums.BookStatus;
import com.vishwa.models.Book;

public class BookUtils {
	
	
	public static List<Book> bookFilter(Iterable<Book> allBooks) {
		Map<Book, Integer> map = new HashMap<>();
		allBooks.forEach(book -> {
			if(!book.getStatus().equals(BookStatus.DELETED)) {
				if(map.containsKey(book)) {
					Integer b = map.get(book);
					map.put(book, b+1);
				} else {
					map.put(book, 1);
				}
			}
		});
		
		List<Book> books = new ArrayList<>();
		map.forEach((book, count) -> { book.setCopies(count); books.add(book);});
		return books;
	}

}
