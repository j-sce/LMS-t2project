package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long isbn;
    String title;
    String publisher;
    Integer year;
    Boolean available;

    @ManyToMany
    @JoinTable(
            name = "book_authors_map",
            joinColumns = {
                    @JoinColumn(name = "book_Id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_Id", referencedColumnName = "id")}
    )
    Set <Author> bookAuthors = new HashSet <Author>();

    @ManyToMany
    @JoinTable(
            name = "book_subject_map",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "subject_id", referencedColumnName = "id")}
    )
    Set <Subject> bookSubjects = new HashSet <>();

    @OneToOne(mappedBy = "book")
    BookIssue bookIssue;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
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
