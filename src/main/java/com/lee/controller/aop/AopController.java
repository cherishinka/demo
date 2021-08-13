package com.lee.controller.aop;

import com.lee.entity.User;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/aop")
@EnableSwagger2
public class AopController {

    @GetMapping("/test")
    public String aop() {

        return "aop controller";
    }


}
