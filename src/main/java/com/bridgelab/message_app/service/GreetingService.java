package com.bridgelab.message_app.service;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting(){
        return "hello world";
    }

}
