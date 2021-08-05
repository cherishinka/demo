package com.lee.service;

import com.lee.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface  UserService {

    void createUser(User user) throws InterruptedException;

}
