package org.jtm.t2project.repo;

import org.jtm.t2project.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Long> {
    @Query(value = "SELECT b.* FROM database_lms.books b "
            + "left join database_lms.book_authors_map am on am.book_id = b.id "
            + "left join database_lms.authors a on am.author_id = a.id where a.name like ?1", nativeQuery = true)
    List <Book> findbyAuthorsNames(String author);


}
