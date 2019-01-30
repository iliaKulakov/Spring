package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceUpdateInfo;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expence;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenceRepository;
import io.github.personal_finance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expence")
public class ExpenceController {

    private ExpenceRepository expenceRepository;
    private CategoryRepository categoryRepository;
    private UsersRepository usersRepository;

    @Autowired
    public ExpenceController(ExpenceRepository expenceRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.expenceRepository = expenceRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Expence> getAllCategory_id() {
        List<Expence> categories = this.expenceRepository.findAll();

        return categories;
    }

    @ResponseBody
    @PostMapping
    public Expence createCategory_id(@RequestBody ExpenceCreateInfo expenceCreateInfo) {

        Category category = this.categoryRepository.findCategoryById(expenceCreateInfo.getCategoryId());
        User user = this.usersRepository.findUserById(expenceCreateInfo.getUserId());

        Expence expence = new Expence(category, user, expenceCreateInfo.getAmount());
        expence = this.expenceRepository.save(expence);
        return expence;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateExpenceTableById(@PathVariable(value = "id") Long id) {
        this.expenceRepository.deleteById(id);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Expence updateExpenceTableById(@PathVariable(value = "id") Long id, @RequestBody ExpenceUpdateInfo expenceUpdateInfo) {

        Category category = this.categoryRepository.findCategoryById(expenceUpdateInfo.getCategoryId());
        Expence expence = this.expenceRepository.findExpenceByid(id);

        expence.setCategory(category);
        expence.setAmount(expenceUpdateInfo.getAmount());

        expence = this.expenceRepository.save(expence);

        return expence;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Expence getExpenceById(@PathVariable(value = "id") Long id) {
        Expence expence = this.expenceRepository.findExpenceByid(id);

        return expence;
    }


}
