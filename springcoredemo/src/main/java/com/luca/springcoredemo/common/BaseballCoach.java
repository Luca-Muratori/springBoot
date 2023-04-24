package com.luca.springcoredemo.common;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


@Component
public class BaseballCoach implements Coach {


    public BaseballCoach(){
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }

    // @PostConstruct
    // public void doStuff(){
    //     System.out.println("In do stuff(): " + getClass().getSimpleName());
    // }

    // @PreDestroy
    // public void doCleanStuff(){
    //     System.out.println("in docleanstuff(): " + getClass().getSimpleName());
    // }

    @Override
    public String getDailyWorkout(){
        return "eat an hot dog";
    }
    
}
