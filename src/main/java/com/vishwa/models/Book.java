package com.vishwa.models;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.vishwa.enums.BookStatus;

@Entity
public class Book {

	@Id
	private int id;
	private String title;
	private String category_name;
	private String dept_name;
	private String author;
	private String lang_name;
	private String description;
	private double price;
	private String version;
	private long entryDate;

	private BookStatus status;
	
	private int copies;
	
	public Book() {
		
	}
	
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getLang_name() {
		return lang_name;
	}
	public void setLang_name(String lang_name) {
		this.lang_name = lang_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String vertion) {
		this.version = vertion;
	}
	public long getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(long entryDate) {
		this.entryDate = entryDate;
	}
	@Transient
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	@Enumerated(EnumType.STRING)
	public BookStatus getStatus() {
		return status;
	}
	public void setStatus(BookStatus status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description + ", price="
				+ price + ", vertion=" + version + ", entryDate=" + entryDate + ", copies=" + copies + "]";
	}
	

	
}
