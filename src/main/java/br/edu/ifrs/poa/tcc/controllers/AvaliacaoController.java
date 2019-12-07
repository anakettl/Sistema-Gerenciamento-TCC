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

import br.edu.ifrs.poa.tcc.models.Avaliacao;
import br.edu.ifrs.poa.tcc.service.AvaliacaoService;

@Controller
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoController {
	
	private AvaliacaoService avaliacoes;

	public AvaliacaoController(AvaliacaoService avaliacoes) {
		super();
		this.avaliacoes = avaliacoes;
	}
	
	@GetMapping("/create")
	public ModelAndView viewSalvar(Avaliacao avaliacao) {
		ModelAndView model = new ModelAndView("avaliacao/create");
		try {
			model.addObject("avaliacao", avaliacao);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("avaliacoes");
			return model;
		}
	}
	
	@PostMapping("/create")
	public ModelAndView salvar(@Valid Avaliacao avaliacao, BindingResult resultado, RedirectAttributes redirecionamento) {
		ModelAndView model = new ModelAndView("redirect:/avaliacoes");
		try {
			if(resultado.hasErrors()) {
				return viewSalvar(avaliacao);
			}
			this.avaliacoes.salvar(avaliacao);
			redirecionamento.addFlashAttribute("message", "Avaliacao salvo com sucesso!");
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			return model;
		}
	}
	
	@GetMapping
	public String todos(Model model) {
		try {
			List<Avaliacao> lista = this.avaliacoes.todos();
			model.addAttribute("avaliacoes", lista);
			return "avaliacao/index";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "error";
		}
	}
	
	@GetMapping("{id}")
	public ModelAndView ver(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("avaliacao/create");
		try {
			Avaliacao avaliacao = this.avaliacoes.avaliacao(id);
			model.addObject("avaliacao", avaliacao);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("avaliacoes");
			return model;
		}
	}
}
