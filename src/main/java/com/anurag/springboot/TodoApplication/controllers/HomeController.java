package com.anurag.springboot.TodoApplication.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private String getLoggedInUser(ModelMap model){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof UserDetails){
            return ((UserDetails)principle).getUsername();
        }
        return principle.toString();
    }

    @GetMapping(value = "/")
    public String showHomePage(ModelMap model){
        model.addAttribute("username", getLoggedInUser(model));
        return "welcome";
    }
}
