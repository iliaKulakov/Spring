package io.github.personal_finance.repos;

import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expence;
import io.github.personal_finance.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence,Long>{

Expence findExpenceByid(Long id);

}





