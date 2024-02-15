package com.mydemoapp.mydemoapp.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run 100KM at 100KM/hr 🏃‍♂️";
    }
}
