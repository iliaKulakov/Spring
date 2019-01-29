package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Expence;
import io.github.personal_finance.repos.ExpenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expence")
public class ExpenceController {

    private ExpenceRepository expenceRepository;

    @Autowired
    public ExpenceController(ExpenceRepository expenceRepository) {
        this.expenceRepository = expenceRepository;
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
        Expence expence = new Expence(expenceCreateInfo.getCategory_id());
        expence = this.expenceRepository.save(expence);
        return expence;
    }

}
