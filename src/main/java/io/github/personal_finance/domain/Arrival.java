package io.github.personal_finance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "Arrival_money")
public class Arrival {

  @Id
  @SequenceGenerator(name = "arrival_seq", sequenceName = "arrival_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arrival_seq")
  private long id;

  @NotNull(message = "amount can't be empty")
  @Column(name = "amount")
  private BigDecimal amount;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;


  public Arrival() {
  }

  public Arrival(long id, @NotNull(message = "amount can't be empty") BigDecimal amount, User user) {
    this.id = id;
    this.amount = amount;
    this.user = user;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
