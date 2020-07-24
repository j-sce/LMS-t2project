package org.jtm.t2project.repo;

import java.util.List;

import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.dao.entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	@Query(value = "SELECT * FROM Books b where b.title like ?1", nativeQuery = true)
	List<Book> findByName(String title);

	@Query(value = "SELECT * FROM Books b where b.isbn like ?1", nativeQuery = true)
	List<Book> findByIsbn(Long isbn);

	@Query(value = "SELECT * FROM Books b where b.publisher like ?1", nativeQuery = true)
	List<Book> findByPublisher(String publisher);

	@Query(value = "SELECT * FROM Books b where b.year like ?1", nativeQuery = true)
	List<Book> findByYear(Integer year);

	@Query(value = "SELECT * FROM Books b where b.available = ?1", nativeQuery = true)
	List<Book> findAvailable(Boolean available);

	@Query(value = "SELECT b.* FROM database_lms.books b "
			+ "left join database_lms.book_subject_map sm on sm.book_id = b.id "
			+ "left join database_lms.subject s on sm.subject_id = s.id where s.id in (?1)", nativeQuery = true)
	List<Book> findbySubject(List<Long> ids);
	
	@Query(value = "SELECT b.* FROM database_lms.books b "
			+ "left join database_lms.book_subject_map sm on sm.book_id = b.id "
			+ "left join database_lms.subject s on sm.subject_id = s.id where s.name like ?1", nativeQuery = true)
	List<Book> findbySubjectNames(String subject);
	
	@Query(value = "SELECT b.* FROM database_lms.books b "
			+ "left join database_lms.book_authors_map am on am.book_id = b.id "
			+ "left join database_lms.authors a on am.author_id = a.id where a.name like ?1", nativeQuery = true)
	List<Book> findbyAuthorsNames(String author);
	

}