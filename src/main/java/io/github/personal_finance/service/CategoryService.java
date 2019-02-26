package io.github.personal_finance.service;

import io.github.personal_finance.domain.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getAllCategoryService();

    Category getCategoryByIdService(Long id);

}
