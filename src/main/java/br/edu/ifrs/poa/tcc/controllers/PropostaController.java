package br.edu.ifrs.poa.tcc.controllers;

import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.security.user.Categoria;
import br.edu.ifrs.poa.tcc.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.service.PropostaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/propostas")
public class PropostaController {
	
	private PropostaService proposta;
	private ProfessorService professor;

	public PropostaController(PropostaService proposta, ProfessorService professor) {
		this.proposta = proposta;
		this.professor = professor;
	}

	@GetMapping("/create")
	public ModelAndView viewSalvar(Proposta proposta) {
		ModelAndView model = new ModelAndView("proposta/create");
		try {
			model.addObject("professores", professor.pegarProfessores());
			model.addObject("proposta", proposta);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("propostas");
			return model;
		}
	}
	@PostMapping("/create")
	public ModelAndView salvar(Proposta proposta, BindingResult resultado, RedirectAttributes redirecionamento) {
		ModelAndView model = new ModelAndView("redirect:/propostas");
		try {
			if(resultado.hasErrors()) {
				return viewSalvar(proposta);
			}
			this.proposta.salvar(proposta);
			redirecionamento.addFlashAttribute("message", "Proposta salva com sucesso!");
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			return model;
		}
	}
	
	@GetMapping("/proposta")
	public String proposta(Proposta proposta, Aluno aluno, Model model) {
		try {
			Proposta p = this.proposta.buscarPropostaPeloAluno(aluno);
			model.addAttribute("proposta", p);
			return "proposta/show";
		} catch (Exception exception) {
			return "/";
		}
	}
}
