package org.jtm.t2project.repo;

import org.jtm.t2project.dao.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository <Author, Long> {

}
