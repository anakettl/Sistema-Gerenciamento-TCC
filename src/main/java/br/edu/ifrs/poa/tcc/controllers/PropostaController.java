package br.edu.ifrs.poa.tcc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Student;
import br.edu.ifrs.poa.tcc.service.PropostaService;

@Controller
public class PropostaController {
	
	private PropostaService proposta;

	public PropostaController(PropostaService proposta) {
		super();
		this.proposta = proposta;
	}
	
	@GetMapping("/proposta")
	public String proposta(Proposta proposta, Student aluno, Model model) {
		try {
			Proposta p = this.proposta.buscarPropostaPeloAluno(aluno);
			model.addAttribute("proposta", p);
			return "proposta/show";
		} catch (Exception exception) {
			return "/";
		}
	}
}
