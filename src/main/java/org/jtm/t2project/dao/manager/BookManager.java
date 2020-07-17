package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.repo.AuthorRepository;
import org.jtm.t2project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

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

}
