package org.jtm.t2project.dao.entity;

import org.jtm.t2project.dao.entity.BookIssue;

import javax.persistence.*;

@Entity
@Table(name = "Members")
public class Member {
    @Id
    private Integer id;

    @OneToOne
    private BookIssue bookIssue;

    private String name;
    private String role;
    private Integer bookLimit;
    private Double fine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookIssue getBookIssue() {
        return bookIssue;
    }

    public void setBookIssue(BookIssue bookIssue) {
        this.bookIssue = bookIssue;
//        bookIssue.addMember(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(Integer bookLimit) {
        this.bookLimit = bookLimit;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }
}
