package org.jtm.t2project.repo;

import org.jtm.t2project.dao.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository <Book, Long> {
    @Query(
            value = "SELECT b.* FROM database_lms.books b " +
                    "Left join database_lms.book_authors_map ba ba.bookId = b.id " +
                    "Left join database_lms.authors a on ba.authorId= a.id "
                    +"where a.id in (?1)",
            nativeQuery = true)
    List<Book> findByAuthor(List <Long> ids);

}
