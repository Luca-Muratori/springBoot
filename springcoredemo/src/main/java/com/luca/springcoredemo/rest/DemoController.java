package com.luca.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luca.springcoredemo.common.Coach;

@RestController
public class DemoController {
    private Coach myCoach;
    //private Coach anotherCoach;

    //Constructor injection + qualifier
    //  @Autowired
    //  public DemoController(@Qualifier("baseballCoach")Coach theCoach){
    //      myCoach=theCoach;
    //  }


    //primary anootation, no need to qualify
    @Autowired
    public DemoController(
        @Qualifier("aquatic")Coach theCoach
       // @Qualifier("soccerCoach")Coach theAnotherCoach
        ){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach=theCoach;
        //anotherCoach=theAnotherCoach;
    }

    // //Setter injection
    // @Autowired
    // public void setCoach(Coach theCoach){
    //     myCoach=theCoach;
    // }

    @GetMapping("/dailyWorkout")    
    public String getWorkout(){
        return myCoach.getDailyWorkout();
    }

    // @GetMapping("/check")    
    // public String check(){
    //     //if true we have singleton, false prototype
    //     return "comparing beans : mycoach==anothercoach " + (myCoach==anotherCoach);
    // }



}
