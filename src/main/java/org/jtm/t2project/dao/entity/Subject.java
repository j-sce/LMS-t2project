package org.jtm.t2project.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {

    public Subject(String name) {
        this.name = name;
    }

    @Id
    private Integer id;
    private String name;


    public String toString() {
        return "Subject{" +
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
