package io.github.personal_finance.repos;


import io.github.personal_finance.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByid(Long id);

}


