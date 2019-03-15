package io.github.personal_finance.domainSecurity.dtoSecurity;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class TokenSecurityTable {

    @Id
    @SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
    private long id;

    @Column(name = "tokens", length = 256)
    private String tokens;


    public TokenSecurityTable() {
    }

    public TokenSecurityTable(long id, String tokens) {
        this.id = id;
        this.tokens = tokens;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }
}
