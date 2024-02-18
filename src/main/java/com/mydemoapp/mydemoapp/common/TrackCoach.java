package com.mydemoapp.mydemoapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// if multiple implementation of Coach are present, this on will be picked
// multiple primaries will fail
// if @Qualifier is used it will have higher precedence
@Primary
@Lazy // will not be initialized unless injected or is called explicitly
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println("👷‍♂️In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run 100KM at 100KM/hr 🏃‍♂️";
    }
}
