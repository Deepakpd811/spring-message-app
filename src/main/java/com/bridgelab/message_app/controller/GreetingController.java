package com.bridgelab.message_app.controller;


import com.bridgelab.message_app.dto.GreetingRequest;
import com.bridgelab.message_app.model.Greeting;
import com.bridgelab.message_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        String message = greetingService.getGreeting(firstname, lastname);

        return Map.of("Message", message);
    }

    // create a greeting message 
    @PostMapping
    public ResponseEntity<Map<String, String>> postGreet(@RequestBody GreetingRequest request) {
        // save to db
        String message = greetingService.postGreetingMessage(request.getFirstname(), request.getLastname());

        return ResponseEntity.ok(Map.of("message ", message));
    }


    // Get greeting by id
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable long id) {
        Optional<Greeting> result = greetingService.getGreetingById(id);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all greeting
    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreeting() {
        List<Greeting> allGreet = greetingService.getAllGreeting();
        return ResponseEntity.ok(allGreet);
    }

    // update the message by id
    @PutMapping("/{id}")
    public ResponseEntity<Greeting> putGreet(
            @RequestBody GreetingRequest request,
            @PathVariable Long id
    ) {

        Optional<Greeting> greeting = greetingService.updateGreeting(id, request.getMessage());

        if (greeting.isPresent()) {
            return ResponseEntity.ok(greeting.get());
        } else {

            return ResponseEntity.notFound().build();
        }

    }

    // delete message by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreet(
            @PathVariable Long id
    ) {
        boolean deleted = greetingService.deleteGreeting(id);

        if (deleted) {
            return ResponseEntity.ok().build();
        } else {

            return ResponseEntity.notFound().build();
        }

    }


}
