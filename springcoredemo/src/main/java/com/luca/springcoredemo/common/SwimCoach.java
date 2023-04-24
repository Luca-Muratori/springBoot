package com.luca.springcoredemo.common;


//not using @COmponent on porpose
public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }
    
    @Override
    public String getDailyWorkout(){
        return "swim 500m";
    }
}
