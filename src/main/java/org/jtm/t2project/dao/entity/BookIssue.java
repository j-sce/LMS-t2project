package org.jtm.t2project.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Book_issue")
public class BookIssue {

    @Id
    private Integer id;

    private Date issue;
    private Date toReturn;
    private Date returned;
    private Double fine;

    //memberid
    //bookid


}
