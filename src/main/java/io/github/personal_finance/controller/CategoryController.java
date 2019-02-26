package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.CategoryCreateInfo;
import io.github.personal_finance.controller.dto.CategoryUpdateInfo;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }




    @ResponseBody
    @GetMapping
    public List<Category> getAllCategory() {
//        List<Category> categories = this.categoryRepository.findAll();
//        return categories;
        List<Category> categories = categoryService.getAllCategoryService();
        return categories;

    }



    @ResponseBody
    @GetMapping(value = "/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long id) {
//        Category category = this.categoryRepository.findCategoryById(id);
//
//        return category;


        Category category = this.categoryService.getCategoryByIdService(id);

        return category;
    }


    @ResponseBody
    @PostMapping
    public Category createCategory(@RequestBody CategoryCreateInfo categoryCreateInfo) {
//        Category category = new Category(categoryCreateInfo.getName());
//        category = this.categoryRepository.save(category);
//        return category;

        Category category = categoryService.createCategoryService(categoryCreateInfo);
        return category;

    }


    @ResponseBody
    @PutMapping(value = "/{id}")
    public Category updateCategoryById(@PathVariable(value = "id") Long id, @RequestBody CategoryUpdateInfo categoryUpdateInfo) {
//        Category categoryByid = this.categoryRepository.findCategoryById(id);
//
//        categoryByid.setName(categoryUpdateInfo.getName());
//
//        categoryByid = this.categoryRepository.save(categoryByid);
//
//        return categoryByid;

        Category categoryByid = categoryService.updateCategoryByIdService(id,categoryUpdateInfo);
        return categoryByid;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateCategoryById(@PathVariable(value = "id") Long id)
    {

//        this.categoryRepository.deleteById(id);
        categoryService.updateCategoryByIdService(id);
    }

}
