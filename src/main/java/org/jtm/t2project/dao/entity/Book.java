package org.jtm.t2project.dao.entity;

import javax.persistence.*;

import org.hibernate.loader.custom.Return;

import java.util.Set;

@Entity
@Table(name = "Books")

public class Book {

	private static final Object[] Book = null;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private int isbn; //ir arī iepriekšējā kodā
	private String title; //ir arī iepriekšējā kodā
	private String publisher; //ir arī iepriekšējā kodā
	private int year; //ir arī iepriekšējā kodā
	private boolean available; //ir arī iepriekšējā kodā
	private String bookSubjects;
	private String bookAuthors;
	private int count; 
	private int bookIssue;
	
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", year=" + year + ", publisher=" + publisher + ", available="
				+ available + ", count=" + count + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getBookSubjects() { 
		return bookSubjects; 
	}
				
	public void setBookSubjects(String bookSubjects) {
		this.bookSubjects = bookSubjects; 
	}
	
	public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getBookIssue() {
		return bookIssue;
	}

	public void setBookIssue(int bookIssue) {
		this.bookIssue = bookIssue;
	}
	
	public void String () {
//		Book [id=" + id + ", isbn=" + isbn + “, title=" + title + ", publisher=" + publisher + “, year=" + year + ", available=" + available + ", bookSubjects=“ + bookSubjects + “, bookAuthors=“ + bookAuthors + “, count=" + count + “, bookIssue=“ + bookIssue + “]”;
				
	}
}