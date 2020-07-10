package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer isbn;
    private String title;
    private String publisher;
    private Integer year;
    private Boolean available;

    @ManyToMany
    @JoinTable(
            name = "book_subject_map",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "subjectId")
    )
    private Set <Subject> bookSubjects;

    @ManyToMany
    @JoinTable(
            name = "Book_Authors_Map",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    private Set <Author> bookAuthors;

    @ManyToOne
    @JoinColumn(name = "Book_issue_id")
    private BookIssue bookIssue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Set <Subject> getBookSubjects() {
        return bookSubjects;
    }

    public void setBookSubjects(Set <Subject> bookSubjects) {
        this.bookSubjects = bookSubjects;
    }

    public Set <Author> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set <Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public BookIssue getBookIssue() {
        return bookIssue;
    }

    public void setBookIssue(BookIssue bookIssue) {
        this.bookIssue = bookIssue;
    }
}
