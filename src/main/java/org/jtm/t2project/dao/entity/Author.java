package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Author(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "bookAuthors")
    private Set <Book> authorsBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set <Book> getAuthorsBooks() {
        return authorsBooks;
    }

    public void setAuthorsBooks(Set <Book> authorsBooks) {
        this.authorsBooks = authorsBooks;
    }

    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
