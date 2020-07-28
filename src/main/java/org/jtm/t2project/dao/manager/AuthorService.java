package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository repo;

    public Set <Author> listAll() {
        return (HashSet <Author>) repo.findAll();
    }

    public void save(Author author) {
        repo.save(author);
    }

    public Author get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
