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

}