package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.domain.User;

import java.util.List;

public interface UserService {

    User createUser(UserCreateDTO userCreateDTO);

    void deleteUser(Long id);

    List<User> getAllUsersService();
}
