package org.jtm.t2project.repo;

import org.jtm.t2project.dao.entity.BookIssue;
import org.jtm.t2project.dao.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepository extends CrudRepository <BookIssue, Long> {

}
