package org.jtm.t2project.repo;

import org.jtm.t2project.dao.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Long> {
    public Author findByName(Author authorName);

}
