package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Author() {
        super();
    }

    @ManyToMany(mappedBy = "bookAuthors",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List <Book> books;

    public List <Book> getAuthorsBooks() {
        return books;
    }

    public void setAuthorsBooks(List <Book> authorsBooks) {
        this.books = authorsBooks;
    }

    public Author(String id) {
        super();
        this.id = new Long(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
