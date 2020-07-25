package org.jtm.t2project.dao.entity;

import org.jtm.t2project.repo.AuthorRepository;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_authors_map",
            joinColumns = {
                    @JoinColumn(name = "book_Id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_Id", referencedColumnName = "id")}
    )
        Set <Author> bookAuthors = new HashSet <Author>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    public Book() {
    }

    public Book(Long isbn, String title, String publisher, Integer year, Boolean available, Author... bookAuthors) {
    this.isbn = isbn;
    this.title = title;
    this.year = year;
    this.publisher = publisher;
    this.available = available;
    this.bookAuthors = Stream.of(bookAuthors).collect(Collectors.toSet());
//    this.bookAuthors.forEach(x -> x.getAuthorsBooks().add(this));
    }

    public void addAuthor(Author author){
        this.bookAuthors.add(author);
//        author.getAuthorsBooks().add(this);
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

//    public List <Subject> getBookSubjects() {
//        return bookSubjects;
//    }
//
//    public void setBookSubjects(List <Subject> bookSubjects) {
//        this.bookSubjects = bookSubjects;
//    }
//
    public Set <Author> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set <Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

//    public BookIssue getBookIssue() {
//        return bookIssue;
//    }
//
//    public void setBookIssue(BookIssue bookIssue) {
//        this.bookIssue = bookIssue;
//    }
}
