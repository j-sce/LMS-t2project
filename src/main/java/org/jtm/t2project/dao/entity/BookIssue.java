package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Book_issue")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date issue;
    private Date toReturn;
    private Date returned;
    private Double fine;

    @OneToMany(
            mappedBy = "Book_issue_id")
    private Set <Book> issuedBooks;

    @OneToOne(
            mappedBy = "Book_issue_id")
    private Member borrower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIssue() {
        return issue;
    }

    public void setIssue(Date issue) {
        this.issue = issue;
    }

    public Date getToReturn() {
        return toReturn;
    }

    public void setToReturn(Date toReturn) {
        this.toReturn = toReturn;
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        this.returned = returned;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public Set <Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(Set <Book> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }
}
