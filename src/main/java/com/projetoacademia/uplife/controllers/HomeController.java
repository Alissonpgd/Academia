package com.projetoacademia.uplife.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@SessionAttributes("httpServletRequest")
@Controller
public class HomeController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("httpServletRequest", httpServletRequest);
    }

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home"; // Renderiza o arquivo templates/home.html
    }
}
