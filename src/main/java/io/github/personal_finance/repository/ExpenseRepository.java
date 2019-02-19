package io.github.personal_finance.repository;

import io.github.personal_finance.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Expense findExpenceByid(Long id);

}





