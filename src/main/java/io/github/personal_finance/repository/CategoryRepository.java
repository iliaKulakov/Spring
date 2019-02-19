package io.github.personal_finance.repository;


import io.github.personal_finance.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryById(Long id);

}


