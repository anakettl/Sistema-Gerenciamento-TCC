package br.edu.ifrs.poa.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {

	@GetMapping("/professor")
    public String index() {
        return "professor/index";
    }
	
	@GetMapping("/professor/create")
	public String create() {
		return "professor/create";
	}
}
