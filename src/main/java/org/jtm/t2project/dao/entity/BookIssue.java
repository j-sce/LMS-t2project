package org.jtm.t2project.dao.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

@OneToMany(
mappedBy = "Book_issue_id")
	private Set <Book> issuedBooks;

@OneToOne(
mappedBy = "Book_issue_id")
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

    public Set <Book> getIssuedBooks() {
    	return getIssuedBooks();
	}
    
    public void setIssuedBooks(Set <Book> issuedBooks) {
    	this.issuedBooks = issuedBooks;
	}

    public Member getBorrower() {
    	return getBorrower();
	}

    public void setBorrower(Member borrower) {
    	this.borrower = borrower;
	}
}
