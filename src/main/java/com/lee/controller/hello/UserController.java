package com.lee.controller.hello;

import com.lee.entity.User;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/user")
@EnableSwagger2
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/{userId}")
    public String getUser(@PathVariable ("userId") String userId) {

        System.out.println(userId);


        return "userId is:" + userId;
    }

    @PostMapping
    public String createUser(@RequestBody User user) throws InterruptedException {
        userService.createUser(user);
        System.out.println("user create requested" + LocalDateTime.now());

        return "user create requested";
    }

}
