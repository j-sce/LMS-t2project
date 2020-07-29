package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Book_issue")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_issue")
    private Date issue;

//    @Temporal(TemporalType.DATE)
    @Column(name = "term_of_return")
    private Date toReturn;

//    @Temporal(TemporalType.DATE)
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

//    @PrePersist
//    protected void onPrePersist() {
//        // TODO set date field to current system date
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        issue = new Date();
//        formatter.format(issue);
//        toReturn = new Date();
//        formatter.format(toReturn);
//        returned = new Date();
//        formatter.format(returned);
//    }
}
