package io.github.ilia_kulakov.controller;

import io.github.ilia_kulakov.model.UserOne;
import io.github.ilia_kulakov.repos.UserAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserAutoRepositoryController {

    private UserAutoRepository userAutoRepository;

    @Autowired
    public UserAutoRepositoryController(UserAutoRepository userAutoRepository){
        this.userAutoRepository = userAutoRepository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserOne createUser(@RequestBody String content){
        UserOne userOne =new UserOne(userOne.getContent());
        userOne = this.userAutoRepository.save(userOne);
        return userOne;
    }

}
