package com.bridgelab.message_app.service;


import com.bridgelab.message_app.model.Greeting;
import com.bridgelab.message_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // greeting message based on firstname and user
    public String getGreeting(String firstname, String lastname) {

        if (firstname != null && lastname != null) {
            return "Hello " + firstname + " " + lastname;
        } else if (firstname != null) {
            return "Hello " + firstname;
        } else if (lastname != null) {
            return "Hello " + lastname;
        } else {
            return "hello world";
        }

    }

    // save the greeting in database
    public String postGreetingMessage(String firstName, String lastName) {
        String message;

        if (firstName != null && !lastName.isBlank()) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null ) {
            message = "Hello " + firstName;
        } else if (lastName != null ) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }

        greetingRepository.save(new Greeting(message));
        return message;
    }


}
