package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.CategoryCreateInfo;
import io.github.personal_finance.controller.dto.CategoryUpdateInfo;
import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.controller.dto.UserUpdateDTO;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repos.CategoryRepository;
import io.github.personal_finance.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Category> getAllCategory() {
        List<Category> categories = this.categoryRepository.findAll();

        return categories;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long id) {
        Category category = this.categoryRepository.findCategoryByid(id);

        return category;
    }


    @ResponseBody
    @PostMapping
    public Category createCategory(@RequestBody CategoryCreateInfo categoryCreateInfo) {
        Category category = new Category(categoryCreateInfo.getName());
        category = this.categoryRepository.save(category);
        return category;
    }


    @ResponseBody
    @PutMapping(value = "/{id}")
    public Category updateCategoryById(@PathVariable(value = "id") Long id, @RequestBody CategoryUpdateInfo categoryUpdateInfo) {
        Category category1 = this.categoryRepository.findCategoryByid(id);

        category1.setName(categoryUpdateInfo.getName());

        category1 = this.categoryRepository.save(category1);

        return category1;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateCategoryById(@PathVariable(value = "id") Long id) {
        this.categoryRepository.deleteById(id);
    }

}