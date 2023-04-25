package com.firstapp.demo.firstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose a endpoint that return 'hello world'
    //1.we import the restcontroller package and add the method at this class by
    //  inserting '@RestController' at the top of this class
    //2.with get mapping annotation we handle the  http GET request that match the given URI (Uniform Resource Identifier), sequence of character that identify one resource from another

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "Goodbye World";
    }

    @GetMapping("/life")
    public String sayLife(){
        return "How are you?";
    }

    //injected propierties
    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.team}")
    private String coachTeam;

    //expose an endpoint that use the info passed
    @GetMapping("/coachInfo")
    public String coach(){
        return "Name: " + coachName +",\nTeam: " + coachTeam;
    }


}
