package com.lee.event;

import com.lee.entity.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


public class UserRegisterEvent extends ApplicationEvent {

    @Getter
    private User user;

    public UserRegisterEvent(Object source, User  user) {
        super(source);
        this.user = user;
    }

}
