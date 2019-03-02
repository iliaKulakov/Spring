package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.CategoryCreateInfo;
import io.github.personal_finance.controller.dto.CategoryUpdateInfo;
import io.github.personal_finance.domain.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getAllCategoryService();

    Category getCategoryByIdService(Long id);

    Category createCategoryService(CategoryCreateInfo categoryCreateInfo);

    Category updateCategoryByIdService(Long id, CategoryUpdateInfo categoryUpdateInfo);

    void updateCategoryByIdService(Long id);

}
