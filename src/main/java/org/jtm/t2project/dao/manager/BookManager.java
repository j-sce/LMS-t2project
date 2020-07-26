package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.repo.AuthorRepository;
import org.jtm.t2project.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    public List <Book> findByAuthor(List <Long> authorIds){
        return bookRepository.findByAuthor(authorIds);
    }
    public List<Author> findAuthors(Author author) {
        List<Author> results = new ArrayList<>();
        authorRepository.findAll().forEach(results::add);
        return results;
    }

	public List<Book> bookAll(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<Book> bookAll(Book book) {
		return null;
	}

	public Book issueBook(Book book) {
		return null;
	}

	public List<Book> findAll(Book book) {
		return null;
	}

	public List<Book> findBySubjectsNames(String subject) {
		return null;
	}

	public List<Book> findByAuthors(String author) {
		return null;
	}

	public List<Book> findBooks(Book book) {
		return null;
	}
*/
    
}
