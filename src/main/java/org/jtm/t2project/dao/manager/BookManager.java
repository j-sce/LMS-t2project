package org.jtm.t2project.dao.manager;

import java.util.*;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.dao.entity.Subject;
import org.jtm.t2project.repo.AuthorRepository;
import org.jtm.t2project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class BookManager {
    private EntityManager entityManager;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }


    public List <Book> findAll(Book book) {
        List <Book> results = new ArrayList <>();
        bookRepository.findAll().forEach(results::add);
        return results;
    }


    public List <Book> findBooks(Book book) {
        List <Book> results = new ArrayList <>();
        bookRepository.findByName(book.getTitle()).forEach(results::add);
        bookRepository.findByIsbn(book.getIsbn()).forEach(results::add);
        bookRepository.findByPublisher(book.getPublisher()).forEach(results::add);
        bookRepository.findByYear(book.getYear()).forEach(results::add);
        bookRepository.findAvailable(book.getAvailable()).forEach(results::add);
        return results;

    }

    public List <Book> findBySubjects(List <Long> ids) {

        return bookRepository.findbySubject(ids);
    }

    public List <Book> findBySubjectsNames(String subject) {

        return bookRepository.findbySubjectNames(subject);
    }

    public List <Book> findByAuthors(String author) {

        return bookRepository.findbyAuthorsNames(author);
    }

    public Optional <Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

//    public List <Book> findByAuthor(List <Long> authorIds){
//        return bookRepository.findByAuthor(authorIds);
//    }

    public Set <Author> findAuthors() {
        Set <Author> results = new HashSet <>();
        authorRepository.findAll().forEach(results::add);
        return results;
    }
}
