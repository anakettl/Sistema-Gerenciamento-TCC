package br.edu.ifrs.poa.sgtcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/home")
    public String welcome() {
        return "welcome";
    }
}
