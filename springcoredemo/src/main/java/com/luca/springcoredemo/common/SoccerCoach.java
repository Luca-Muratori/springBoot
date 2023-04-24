package com.luca.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SoccerCoach implements Coach {

    public SoccerCoach(){
        System.out.println("in constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "RUn 15 minutes    ";
    }
    
}
