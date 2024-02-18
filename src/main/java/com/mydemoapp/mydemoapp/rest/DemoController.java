package com.mydemoapp.mydemoapp.rest;

import com.mydemoapp.mydemoapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;
    private final Coach theOtherCoach;
    private final Coach myTennisCoach;


    //    autowire is optional when 1 constructor is defined
    // currently only 1 coach is defined so autowire imports the CricketCoach

    // Spring behind the scenes creates a new coach and injects it in the constructor
    // Coach myCoach = new CricketCoach()
    // DemoController demoController = new DemoController(myCoach)
//    -----------------------------------------
// constructor injection (recommended)
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theOtherCoach,
                          @Qualifier("tennisCoach") Coach myTennisCoach) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;
        this.theOtherCoach = theOtherCoach;
        this.myTennisCoach = myTennisCoach;
    }
//    -----------------------------------------

//    -----------------------------------------

    // setter injection (for optional dependencies)
    // (as long as it's annotated with autowired it can be named to anything)
// when we have multiple beans that implements Coach spring will fail to know which to inject
// we have to use the qualifier to determine which, notice it starts with lower case
//    @Autowired
//    public void setCoach(@Qualifier("trackCoach") Coach theCoach){
//        myCoach = theCoach;
//    }
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

//    this will return true because singleton is the default value pointing to the same bean
    @GetMapping("/check")
    public String getBeans(){return "Comparing beans: myCoach == theOtherCoach: " + (myCoach == theOtherCoach);}

    @GetMapping("/lifecycle")
    public String lifeCycle(){return "Checking lifecycles, check log 👇";}
}

