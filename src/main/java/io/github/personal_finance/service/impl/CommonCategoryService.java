package io.github.personal_finance.service.impl;

import io.github.personal_finance.controller.dto.CategoryCreateInfo;
import io.github.personal_finance.controller.dto.CategoryUpdateInfo;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public Category createCategoryService(CategoryCreateInfo categoryCreateInfo) {
        Category category = new Category(categoryCreateInfo.getName());
        category = this.categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategoryByIdService(Long id, CategoryUpdateInfo categoryUpdateInfo) {
        Category categoryByid = this.categoryRepository.findCategoryById(id);

        categoryByid.setName(categoryUpdateInfo.getName());

        categoryByid = this.categoryRepository.save(categoryByid);

        return categoryByid;
    }

    @Override
    public void updateCategoryByIdService(Long id) {
        this.categoryRepository.deleteById(id);
    }

}
