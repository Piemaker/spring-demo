package com.mydemoapp.mydemoapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play tennis with a friend 🎾";
    }
}
