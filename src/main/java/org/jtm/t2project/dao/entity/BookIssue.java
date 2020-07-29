package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Book_issue")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date issue;
    private Date toReturn;
    private Date returned;
    private Double fine;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member borrower;

    public BookIssue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }
}
