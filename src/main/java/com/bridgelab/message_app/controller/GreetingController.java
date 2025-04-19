package com.bridgelab.message_app.controller;


import com.bridgelab.message_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    Map<String, String> response = new HashMap<>();

    @Autowired
    private GreetingService greetingService;

  
    // Accept fristname and lastname as optional query param
    @GetMapping
    public Map<String, String> getGreet(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname
    ) {

        String message = greetingService.getGreeting(firstname,lastname);

        return Map.of("Message",message);
    }

    @PostMapping
    public Map<String, String> postGreet() {
        response.put("Message ", "Good morning post");
        return response;
    }

    @PutMapping
    public Map<String, String> putGreet() {
        response.put("Message ", "Good morning put");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreet() {
        response.put("Message ", "Good morning delete");
        return response;
    }


}
