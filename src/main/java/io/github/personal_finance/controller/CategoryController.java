package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.CategoryCreateInfo;
import io.github.personal_finance.controller.dto.UserCreateDTO;
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
    @PostMapping
    public Category createCategory(@RequestBody CategoryCreateInfo categoryCreateInfo) {
        Category category = new Category(categoryCreateInfo.getName());
        category = this.categoryRepository.save(category);
        return category;
    }


}