package org.jtm.t2project.dao.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.dao.entity.Subject;
import org.jtm.t2project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManager {
    private EntityManager entityManager;

//    @Autowired
//    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

//    public Author insertAuthor (Author murakami){
//        return authorRepository.save(murakami);
//    }

    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> findAll(Book book) {
    	List<Book> results = new ArrayList<>();
    	bookRepository.findAll().forEach(results::add);
    	return results;
    }
        
    
    public List<Book> findBooks(Book book){
    	List<Book> results = new ArrayList<>();
    	bookRepository.findByName(book.getTitle()).forEach(results::add);
    	bookRepository.findByIsbn(book.getIsbn()).forEach(results::add);
    	bookRepository.findByPublisher(book.getPublisher()).forEach(results::add);
    	bookRepository.findByYear(book.getYear()).forEach(results::add);
    	bookRepository.findAvailable(book.getAvailable()).forEach(results::add);
		return results;
  	
    }
    
    public List<Book> findBySubjects(List<Long> ids){

		return bookRepository.findbySubject(ids);
    }
    
    public List<Book> findBySubjectsNames(String name){

		return bookRepository.findbySubjectNames(name);
    }
    
}