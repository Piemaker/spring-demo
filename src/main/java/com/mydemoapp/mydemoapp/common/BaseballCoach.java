package com.mydemoapp.mydemoapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach(){
        System.out.println("👷‍♂️In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Play baseball all day long ⚾🧢⚾";
    }
}
