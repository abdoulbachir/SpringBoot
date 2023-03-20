package com.bachir.springbootdemo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //injecting properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;


    //Expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String teaminfor(){
        return "Coach: "+coachName + ", Team name: "+teamName;
    }

    //Expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    //Expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day.";
    }


}
