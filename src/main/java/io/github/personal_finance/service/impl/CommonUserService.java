package io.github.personal_finance.service.impl;

import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonUserService implements UserService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    private UsersRepository usersRepository;

    @Autowired
    public CommonUserService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public User createUser(UserCreateDTO userCreateDTO){
        User user = new User(userCreateDTO.getUsername());
        user = this.usersRepository.save(user);
        return user;
    }


}
