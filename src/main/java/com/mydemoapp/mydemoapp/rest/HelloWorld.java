package com.mydemoapp.mydemoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("$(name)")
    private String name;

    @Value("$(name.middleName)")
    private String middleName;
    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hey there 👋 " + name + " " + middleName  ;
    }

    @GetMapping("/workout")
    public String getWorkout(){
        return """
                1-100 Pushups 🫷🫸
                2-100 Cruches
                3-100 Squats
                4-10 KM Run 🏃‍♂️
                """;
    }
}
