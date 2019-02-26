package io.github.personal_finance.service.impl;

import io.github.personal_finance.domain.Category;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CommonCategoryService implements CategoryService {


    private CategoryRepository categoryRepository;

    @Autowired
    public CommonCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategoryService(){
    List<Category> categories = this.categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryByIdService(Long id) {
        Category category = this.categoryRepository.findCategoryById(id);

        return category;}



}
