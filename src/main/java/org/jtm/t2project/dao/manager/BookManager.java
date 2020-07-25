package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.repo.AuthorRepository;
import org.jtm.t2project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
