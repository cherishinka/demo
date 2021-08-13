package com.lee.serviceImpl;

import com.lee.entity.User;
import com.lee.event.UserRegisterEvent;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("UserService")
public class UserServiceImpl implements UserService {

    /**
     * 用于出发事件
     */
    @Autowired
    ApplicationContext applicationContext;

    @Async
    @Override
    public  void createUser(User user) throws InterruptedException {
        System.out.println("create start time:"+LocalDateTime.now());

        Thread.sleep(5000);

        // 注册成功，触发事件
        applicationContext.publishEvent(new UserRegisterEvent(this, user));
        System.out.println("create end time:"+LocalDateTime.now());
    }


}
