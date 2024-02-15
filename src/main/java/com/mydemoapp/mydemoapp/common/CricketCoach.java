package com.mydemoapp.mydemoapp.common;

import org.springframework.stereotype.Component;

//this marks it available for dependancy injection
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 min ⌚";
    }
}
