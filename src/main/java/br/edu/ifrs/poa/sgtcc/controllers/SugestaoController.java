package br.edu.ifrs.poa.sgtcc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.poa.sgtcc.models.Sugestao;
import br.edu.ifrs.poa.sgtcc.service.ProfessorService;
import br.edu.ifrs.poa.sgtcc.service.SugestaoService;

@Controller
@RequestMapping(value = "/sugestoes")
public class SugestaoController {
	
	private SugestaoService sugestoes;
	private ProfessorService professorService;

	public SugestaoController(SugestaoService sugestoes, ProfessorService professorService) {
		super();
		this.sugestoes = sugestoes;
		this.professorService = professorService;
	}
	
	@GetMapping("/create")
	    public ModelAndView viewSalvar(Sugestao sugestao) { 
        ModelAndView model = new ModelAndView("sugestao/create");
        model.addObject("professores", professorService.pegarProfessores());
        model.addObject("sugestao", sugestao);
        return model;
		
	}
	
	@PostMapping("/create")
    public ModelAndView salvarSugestao(@Valid Sugestao sugestao, BindingResult resultadoValidacao, RedirectAttributes redirecionamentoDeAtributos, Model model) {
        if (resultadoValidacao.hasErrors()) {
            model.addAttribute("erros", resultadoValidacao.getAllErrors());
            return viewSalvar(sugestao);
        }
        sugestoes.salvar(sugestao);
        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Proposta criada com sucesso!");
        return new ModelAndView("redirect:/sugestoes");
    }
	
	@GetMapping
	public String todos(Model model) {
		try {
			List<Sugestao> lista = this.sugestoes.todos();
			model.addAttribute("sugestoes", lista);
			return "sugestao/index";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "error";
		}
	}

	@GetMapping("/{id}")
	public ModelAndView ver(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("sugestao/create");
		try {
			Sugestao sugestao = this.sugestoes.sugestao(id);
			model.addObject("sugestao", sugestao);
			model.addObject("professores", sugestao.getProfessor());
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("sugestao/index");
			return model;
		}
	}

	@DeleteMapping("/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("redirect:/sugestoes");
		try {
			this.sugestoes.excluir(id);
			model.addObject("alunos", this.sugestoes.todos());
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("sugestao/index");
			return model;
		}
	}
}
