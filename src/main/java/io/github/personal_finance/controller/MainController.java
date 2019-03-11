package io.github.personal_finance.controller;

import io.github.personal_finance.domain.Hello;
import io.github.personal_finance.securityService.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return
                new Hello(counter.incrementAndGet(),
                        String.format(template, name));
    }

}
