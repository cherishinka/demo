package com.lee.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener {

    @EventListener
    public void handleApplicationReady(ApplicationReadyEvent applicationReadyEvent) {

        System.out.println("***************Application Ready!!***************");

    }
}
