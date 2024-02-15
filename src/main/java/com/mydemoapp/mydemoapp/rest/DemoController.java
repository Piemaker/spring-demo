package com.mydemoapp.mydemoapp.rest;

import com.mydemoapp.mydemoapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //    autowire is optional when 1 constructor is defined
    // currently only 1 coach is defined so autowire imports the CricketCoach

    // Spring behind the scenes creates a new coach and injects it in the constructor
    // Coach myCoach = new CricketCoach()
    // DemoController demoController = new DemoController(myCoach)
//    -----------------------------------------
// constructor injection (recommended)
//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//    }
//    -----------------------------------------

//    -----------------------------------------

    // setter injection (for optional dependencies)
    // (as long as it's annotated with autowired it can be named to anything)

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }
//    -----------------------------------------

//    -----------------------------------------
    // field injection (not recommended, makes code harder to unit test)
//    @Autowired
//    private Coach getMyCoach;
//    -----------------------------------------


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
