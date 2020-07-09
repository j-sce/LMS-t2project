package org.jtm.t2project.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
public class Author {

    public Author(String name) {
        this.name = name;
    }

    @Id
    private Integer id;
    private String name;

    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @ManyToOne
//    @JoinColumn
//    private Book book;



}
