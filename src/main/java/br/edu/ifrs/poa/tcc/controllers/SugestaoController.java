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

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Sugestao;
import br.edu.ifrs.poa.tcc.service.ProfessorService;
import br.edu.ifrs.poa.tcc.service.SugestaoService;

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
    public ModelAndView salvarSugestao(@Valid Sugestao sugestao, BindingResult resultadoValidacao, Model model, RedirectAttributes redirecionamentoDeAtributos) {
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
	
	@GetMapping("{id}")
	public ModelAndView ver(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("sugestao/create");
		try {
			Sugestao sugestao = this.sugestoes.sugestao(id);
			model.addObject("sugestao", sugestao);
			return model;
		} catch (Exception exception) {
			model.addObject("erro", exception.getMessage());
			model.setViewName("sugestoes");
			return model;
		}
	}
	
	@GetMapping
    public String SugestoesCriadas(Model model) {
        model.addAttribute("propostasCriadas", sugestoes.pegarSugestoes());
        return "sugestoes/index";
    }
}
