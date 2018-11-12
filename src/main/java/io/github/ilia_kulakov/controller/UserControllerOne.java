package io.github.ilia_kulakov.controller;

import io.github.ilia_kulakov.model.User;
import io.github.ilia_kulakov.model.UserOne;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserControllerOne {
    private List users = new ArrayList<>();


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getUsers() {
        return this.users;
    }


    @ResponseBody
    @RequestMapping(value = "{userId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserOne updateUser(@PathVariable("userId") Integer userId) {
        UserOne user = this.users.get(userId);
        user.setContent("ranom-content");
        this.users.set(userId, user);
        return user;
    }


    @ResponseBody
    @RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Integer userId) {
        this.users.remove(userId);
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserOne createUser(@RequestBody String content) {
        UserOne user = new UserOne(content);
        this.users.add(user);
        return user;
    }
}