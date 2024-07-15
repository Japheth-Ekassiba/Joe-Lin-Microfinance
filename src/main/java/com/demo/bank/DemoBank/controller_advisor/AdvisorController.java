package com.demo.bank.DemoBank.controller_advisor;

import com.demo.bank.DemoBank.model.User;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice
public class AdvisorController {
    @ModelAttribute("registerUser")
    public User getUserDefaults(){

        return new User();
    }
}
