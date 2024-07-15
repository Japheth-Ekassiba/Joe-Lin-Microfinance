package com.demo.bank.DemoBank.controllers;

import com.demo.bank.DemoBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle","Home");
        System.out.println("In Index Controller");
        return getIndexPage;
    }





    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("In Error Page Controller");
        getErrorPage.addObject("PageTitle", "Errors");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token") String token,
                                  @RequestParam("code") String code){

        //Set View:
        ModelAndView getVerifyPage = new ModelAndView("verify");

        //Get Token In Database:
        String dbToken = userRepository.checkToken(token);

        //Check If Token Is Valid:
        if(dbToken == null){
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error", "This Session Has Expired");
            return  getVerifyPage;
        }
        //End Of Check If Token Is Valid.

        //Update and Vefify Account:
        userRepository.verifyAccount(token,code);
        getVerifyPage = new ModelAndView("login");
        System.out.println("In Verify Page Controller");
        getVerifyPage.addObject("success", "Account verified successfully, please proceed to login");
        return getVerifyPage;
    }
}
