package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "bookSubjects")
    private Set <Book> booksOfSubject;

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

    public Set <Book> getBooksOfSubject() {
        return booksOfSubject;
    }

    public void setBooksofsubject(Set <Book> booksofsubject) {
        this.booksOfSubject = booksofsubject;
    }

    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
