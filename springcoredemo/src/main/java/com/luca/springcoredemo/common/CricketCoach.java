package com.luca.springcoredemo.common;

// import org.springframework.context.annotation.Lazy;
// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
//@Primary
//@Lazy 
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes    ";
    }
    
}
