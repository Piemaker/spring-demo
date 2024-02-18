package com.mydemoapp.mydemoapp.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//this marks it available for dependancy injection
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // a new object is created for each injection
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("👷‍♂️In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 min ⌚";
    }
}
