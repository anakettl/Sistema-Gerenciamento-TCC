package br.edu.ifrs.poa.tcc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.service.AlunoService;

@Controller
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	private AlunoService alunos;

	public AlunoController(AlunoService alunos) {
		super();
		this.alunos = alunos;
	}
	
	@GetMapping("/create")
	@Transactional
	public String viewSalvar(Aluno aluno, Model model) {
		try {
			model.addAttribute("aluno", aluno);
			return "aluno/create";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "/alunos";
		}
	}
	
	@PostMapping("/create")
	@Transactional
	public String salvar(@Valid Aluno aluno, BindingResult resultado, RedirectAttributes redirecionamento, Model model) {
		try {
			if(resultado.hasErrors()) {
				return "redirect:/alunos/create";
			}
			this.alunos.salvar(aluno);
			redirecionamento.addFlashAttribute("message", "Aluno salvo com sucesso!");
			return "redirect:/alunos";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "/alunos";
		}
	}
	
	@GetMapping
	public String todos(Model model) {
		try {
			List<Aluno> lista = this.alunos.todos();
			model.addAttribute("alunos", lista);
			return "aluno/index";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "error";
		}
	}
	
}