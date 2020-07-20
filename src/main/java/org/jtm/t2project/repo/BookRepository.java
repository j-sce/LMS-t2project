package org.jtm.t2project.repo;

import java.util.List;

import org.jtm.t2project.dao.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {

	@Query(
			value = "SELECT * FROM Books b where b.title like ?1",
			nativeQuery = true)
	List<Book> findByName(String title);
	
	@Query(
			value = "SELECT * FROM Books b where b.isbn like ?1",
			nativeQuery = true)
	List<Book> findByIsbn(Long isbn);
	
	@Query(
			value = "SELECT * FROM Books b where b.publisher like ?1",
			nativeQuery = true)
	List<Book> findByPublisher(String publisher);
	
	@Query(
			value = "SELECT * FROM Books b where b.year like ?1",
			nativeQuery = true)
	List<Book> findByYear(Integer year);
	
	@Query(
			value = "SELECT * FROM Books b where b.available = ?1",
			nativeQuery = true)
	List<Book> findAvailable(Boolean available);

}