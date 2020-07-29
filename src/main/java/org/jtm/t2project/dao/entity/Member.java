package org.jtm.t2project.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "Members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private Integer bookLimit;

    @Column(name = "non_paid_fine")
    private Double fine;

    @OneToOne(mappedBy = "borrower")
    private BookIssue bookIssue;

    public Member() {
    }

    public Member(String id) {
        super();
        this.id = new Long(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
