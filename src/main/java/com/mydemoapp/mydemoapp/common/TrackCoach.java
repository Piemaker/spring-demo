package com.mydemoapp.mydemoapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// if multiple implementation of Coach are present, this on will be picked
// multiple primaries will fail
// if @Qualifier is used it will have higher precedence
@Primary
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run 100KM at 100KM/hr 🏃‍♂️";
    }
}
