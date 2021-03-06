package br.edu.ifrs.poa.sgtcc.controllers;

import br.edu.ifrs.poa.sgtcc.models.Proposta;
import br.edu.ifrs.poa.sgtcc.service.AlunoService;
import br.edu.ifrs.poa.sgtcc.service.ProfessorService;
import br.edu.ifrs.poa.sgtcc.service.PropostaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/propostas")
public class PropostaController {

    private AlunoService alunoService;
    private PropostaService propostaService;
    private ProfessorService professorService;

    public PropostaController(PropostaService propostaService, ProfessorService professorService, AlunoService alunoService) {
        this.propostaService = propostaService;
        this.professorService = professorService;
        this.alunoService = alunoService;
    }

    @GetMapping("/create")
    public ModelAndView criarProposta(Proposta proposta) {
        ModelAndView model = new ModelAndView("proposta/create");
        model.addObject("professores", professorService.pegarProfessores());
        model.addObject("proposta", proposta);
        return model;
    }

    @PostMapping("/create")
    public ModelAndView salvarProposta(@Valid Proposta proposta, BindingResult resultadoValidacao, Model model, RedirectAttributes redirecionamentoDeAtributos) {
        if (resultadoValidacao.hasErrors()) {
            model.addAttribute("erros", resultadoValidacao.getAllErrors());
            return criarProposta(proposta);
        }
        proposta.setAutor(this.alunoService.aluno(1));
        propostaService.salvar(proposta);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Proposta criada com sucesso!");
        return new ModelAndView("redirect:/propostas");
    }

    @GetMapping
    public String PropostasCriadas(Model model) {
        model.addAttribute("propostasCriadas", propostaService.pegarPropostas());
        return "proposta/index";
    }

    @GetMapping("/{id}")
    public ModelAndView ver(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("proposta/create");
        try {
            Proposta proposta = this.propostaService.encontraUma(id);
            model.addObject("proposta", proposta);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setView(new RedirectView("redirect:/propostas"));
            return model;
        }
    }
    
    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("redirect:/propostas");
        try {
        	this.propostaService.excluir(id);
            model.addObject("propostas", this.propostaService.todos());
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("propostas");
            return model;
        }
    }
    
    

}
