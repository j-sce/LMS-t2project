package org.jtm.t2project.dao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Book_issue")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_issue")
    private Date issue;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "term_of_return")
    private Date toReturn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "actual_return_date")
    private Date returned;

    @Column(name = "fine_amount")
    private Double fine;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookToIssue;

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

    public Book getBookToIssue() {
        return bookToIssue;
    }

    public void setBookToIssue(Book bookToIssue) {
        this.bookToIssue = bookToIssue;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

}
