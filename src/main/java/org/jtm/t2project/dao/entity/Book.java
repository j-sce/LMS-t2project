package org.jtm.t2project.dao.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer isbn;
    String title;
    String publisher;
    Integer year;
    Boolean available;

//    @OneToMany
//    @JoinTable(
//            name = "Book_Subject_Map",
//            joinColumns = {
//                    @JoinColumn(name = "bookId", referencedColumnName = "id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "subjectId", referencedColumnName = "id")}
//    )
//    @Lazy
//    List <Subject> bookSubjects = new ArrayList <>();
//
//    @OneToMany
//    @JoinTable(
//            name = "Book_Authors_Map",
//            joinColumns = {
//                    @JoinColumn(name = "bookId", referencedColumnName = "id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "authorId", referencedColumnName = "id")}
//    )
//    @Lazy
//    List <Author> bookAuthors = new ArrayList <>();

//    @ManyToOne
//    @JoinColumn(name = "Book_issue_id")
//    private BookIssue bookIssue;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    public List <Subject> getBookSubjects() {
//        return bookSubjects;
//    }
//
//    public void setBookSubjects(List <Subject> bookSubjects) {
//        this.bookSubjects = bookSubjects;
//    }
//
//    public List <Author> getBookAuthors() {
//        return bookAuthors;
//    }
//
//    public void setBookAuthors(List <Author> bookAuthors) {
//        this.bookAuthors = bookAuthors;
//    }

//    public BookIssue getBookIssue() {
//        return bookIssue;
//    }
//
//    public void setBookIssue(BookIssue bookIssue) {
//        this.bookIssue = bookIssue;
//    }
}
