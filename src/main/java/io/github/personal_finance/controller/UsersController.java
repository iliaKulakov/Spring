package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.controller.dto.UserUpdateDTO;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = this.usersRepository.findAll();

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

        user.setUsername(userUpdateDTO.getUsername());

        user = this.usersRepository.save(user);

        return user;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateUserById(@PathVariable(value = "id") Long id) {
        this.usersRepository.deleteById(id);
    }

    @ResponseBody
    @PostMapping
    public User createUser(@RequestBody UserCreateDTO userCreateDTO) {
        User user = new User(userCreateDTO.getUsername());
        user = this.usersRepository.save(user);
        return user;
    }

}