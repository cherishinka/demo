package com.lee.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @EventListener
    public void handleApplicationReady(UserRegisterEvent userRegisterEvent) {

        System.out.println("***************user register successfully!!***************");
        System.out.println("***************user id=" + userRegisterEvent.getUser().getUserId());

    }
}
