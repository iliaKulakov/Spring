package io.github.ilia_kulakov.domain;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = 'my_first_table')
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "content")
    private String Content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}