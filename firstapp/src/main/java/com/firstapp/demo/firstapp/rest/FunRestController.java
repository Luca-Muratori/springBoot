package com.firstapp.demo.firstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose a endpoint that return 'hello world'
    //1.we import the restcontroller package and add the method at this class by
    //  inserting '@RestController' at the top of this class
    //2.with get mapping annotation we handle the  http GET request that match the given URI (Uniform Resource Identifier), sequence of character that identify one resource from another

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
