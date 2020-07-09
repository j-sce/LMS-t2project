package org.jtm.t2project.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    private Integer id;

    private Integer isbn;
    private String title;
    private String publisher;
    private Integer year;
    private Boolean available;

    @OneToMany(mappedBy = "authors")
    @OrderBy("id ASC")
    private Set <Author> authors;

    @OneToMany(mappedBy = "subjects")
    @OrderBy("id ASC")
    private Set <Subject> subjects;

    @ManyToOne
    @JoinColumn
    private BookIssue bookIssue;




}
