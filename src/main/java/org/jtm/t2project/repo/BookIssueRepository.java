package org.jtm.t2project.repo;

import java.util.List;

import org.jtm.t2project.dao.entity.Book;
import org.jtm.t2project.dao.entity.BookIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRepository extends CrudRepository <BookIssue, Long> {


	 @Query(value = "SELECT book_issue.id, book_issue.bookID, book_issue.memberID, book_issue.date_of_issue, book_issue.term_of_return, book_issue.actual_return_date, book_issue.fine_amount", nativeQuery = true)        
	 public List<Book> bookIssueList(List <Long> ids);
	}
