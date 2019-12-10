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

import br.edu.ifrs.poa.tcc.models.Banca;
import br.edu.ifrs.poa.tcc.service.BancaService;

@Controller
@RequestMapping(value = "/bancas")
public class BancaController {
	
	private BancaService bancas;

	public BancaController(BancaService bancas) {
		super();
		this.bancas = bancas;
	}
	
	@GetMapping("/create")
	public ModelAndView viewSalvar(Banca banca) {
		ModelAndView model = new ModelAndView("banca/create");
		try {
			model.addObject("banca", banca);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("bancas");
			return model;
		}
	}
	
	@PostMapping("/create")
	public ModelAndView salvar(@Valid Banca banca, BindingResult resultado, RedirectAttributes redirecionamento) {
		ModelAndView model = new ModelAndView("redirect:/bancas");
		try {
			if(resultado.hasErrors()) {
				return viewSalvar(banca);
			}
			this.bancas.salvar(banca);
			redirecionamento.addFlashAttribute("message", "Banca salva com sucesso!");
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			return model;
		}
	}
	
	@GetMapping
	public String todos(Model model) {
		try {
			List<Banca> lista = this.bancas.todos();
			model.addAttribute("bancas", lista);
			return "banca/index";
		} catch (Exception exception) {
			model.addAttribute("erro", exception.getMessage());
			return "error";
		}
	}
	
	@GetMapping("{id}")
	public ModelAndView ver(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("banca/create");
		try {
			Banca banca = this.bancas.banca(id);
			model.addObject("banca", banca);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("bancas");
			return model;
		}
	}
	
	
}
