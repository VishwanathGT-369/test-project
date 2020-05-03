package com.vishwa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vishwa.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("select distinct(title) from Book")
	public List<String> getBookNames();

}
