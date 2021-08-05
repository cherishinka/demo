package com.lee.serviceImpl;

import com.lee.entity.User;
import com.lee.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("UserService")
public class UserServiceImpl implements UserService {

    @Async
    @Override
    public  void createUser(User user) throws InterruptedException {
        System.out.println("create start time:"+LocalDateTime.now());

        Thread.sleep(5000);


        System.out.println("create end time:"+LocalDateTime.now());
    }


}
