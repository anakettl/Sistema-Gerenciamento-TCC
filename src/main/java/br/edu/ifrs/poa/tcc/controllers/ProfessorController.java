package br.edu.ifrs.poa.tcc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.service.ProfessorService;

@Controller
@RequestMapping(value = "/professores")
public class ProfessorController {
	
	private ProfessorService professores;

	public ProfessorController(ProfessorService professores) {
		super();
		this.professores = professores;
	}
	
	@GetMapping("/create")
	public ModelAndView viewSalvar(Professor professor) {
		ModelAndView model = new ModelAndView("professor/create");
		try {
			model.addObject("professor", professor);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("professores");
			return model;
		}
	}
	
	@PostMapping("/create")
	public ModelAndView salvar(@Valid Professor professor, BindingResult resultado, RedirectAttributes redirecionamento) {
		ModelAndView model = new ModelAndView("redirect:/professores");
		try {
			if(resultado.hasErrors()) {
				return viewSalvar(professor);
			}
			this.professores.salvar(professor);
			redirecionamento.addFlashAttribute("message", "Professor salvo com sucesso!");
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			return model;
		}
	}
	
	@GetMapping
	public String todos(Model model) {
		try {
			List<Professor> lista = this.professores.todos();
			model.addAttribute("professores", lista);
			return "professor/index";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "error";
		}
	}
	
	@GetMapping("{id}")
	public ModelAndView ver(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("professor/create");
		try {
			Professor professor = this.professores.professor(id);
			model.addObject("professor", professor);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("professores");
			return model;
		}
	}
}
