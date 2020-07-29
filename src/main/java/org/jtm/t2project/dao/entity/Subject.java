package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToMany(mappedBy = "bookSubjects",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List <Book> books;

    public List <Book> getBooks() {
        return books;
    }

    public void setBooks(List <Book> books) {
        this.books = books;
    }

    public Subject() {
        super();
    }

    public Subject(String id) {
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
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
