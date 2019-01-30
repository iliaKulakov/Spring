package io.github.personal_finance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private long id;

    //@NotNull(message = "name of user can't be empty")
    @Column(name = "name", length = 256)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Column(name = "user_id")
    private List<Expence> expences;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expence> getExpences() {
        return expences;
    }

    public void setExpences(List<Expence> expences) {
        this.expences = expences;
    }
}
