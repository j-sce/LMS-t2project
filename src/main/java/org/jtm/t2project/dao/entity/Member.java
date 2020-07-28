package org.jtm.t2project.dao.entity;

import java.util.Date;

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
    private Double fine;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    @Override
	public String toString() {
		return "BookIssue [id=" + id + ", name=" + name + ", role=" + role + ", fine=" + fine + ", bookLimit=" + bookLimit + "]";
	}

}