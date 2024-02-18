package com.mydemoapp.mydemoapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("👷‍♂️In constructor: "+ getClass().getSimpleName());
    }

    @PostConstruct
    public void myPostConstruct(){
        System.out.println("In myPostConstruct: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Play tennis with a friend 🎾";
    }

    @PreDestroy
    public void myPreDestory(){
        System.out.println("In myPreDestroy: "+ getClass().getSimpleName());
    }
}
