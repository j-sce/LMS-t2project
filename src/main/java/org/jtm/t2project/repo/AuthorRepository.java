package org.jtm.t2project.repo;

import java.util.List;

import org.jtm.t2project.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository <Author, Long> {
	
}
