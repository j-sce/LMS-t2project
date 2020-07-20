package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Subject")
public class Subject {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    


    public Subject() {
		super();
		// TODO Auto-generated constructor stub
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

	public Subject(String name) {
		super();
		this.name = name;
	}




//    public Set <Book> getBooksOfSubject() {
//        return booksOfSubject;
//    }
//
//    public void setBooksofsubject(Set <Book> booksofsubject) {
//        this.booksOfSubject = booksofsubject;
//    }

    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
