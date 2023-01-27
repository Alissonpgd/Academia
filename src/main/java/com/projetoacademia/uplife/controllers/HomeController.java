package com.projetoacademia.uplife.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@SessionAttributes("httpServletRequest")
@Controller
public class HomeController {

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home"; // Renderiza o arquivo templates/home.html
    }
}
