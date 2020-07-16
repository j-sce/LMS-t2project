package org.jtm.t2project.dao.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jtm.t2project.dao.entity.Author;
import org.jtm.t2project.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository repo;

    public List <Author> listAll() {
        return (ArrayList <Author>) repo.findAll();
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
