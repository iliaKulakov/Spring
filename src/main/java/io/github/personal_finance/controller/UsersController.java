package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.controller.dto.UserUpdateDTO;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersRepository usersRepository;
    private UserService userService;

    @Autowired
    public UsersController(UsersRepository usersRepository, UserService userService) {
        this.usersRepository = usersRepository;
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = this.userService.getAllUsersService();
        return users;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        User user = this.usersRepository.findUserById(id);

        return user;
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable(value = "id") Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        User user = this.usersRepository.findUserById(id);

        user.setName(userUpdateDTO.getUsername());

        user = this.usersRepository.save(user);

        return user;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateUserById(@PathVariable(value = "id") Long id) {
        this.userService.deleteUser(id);
    }

    @ResponseBody
    @PostMapping
    public User createUser(@RequestBody UserCreateDTO userCreateDTO) {
        User user = this.userService.createUser(userCreateDTO);
        return user;
    }

}
