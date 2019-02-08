package io.github.personal_finance.repository;

import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArrivalRepository {

    @Repository
    public interface Arrivalepository extends JpaRepository<Arrival, Long> {

        Arrival findArrivalByid(Long id);

    }

}
