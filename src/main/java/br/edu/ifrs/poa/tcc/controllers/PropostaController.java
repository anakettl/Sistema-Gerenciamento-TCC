package br.edu.ifrs.poa.tcc.controllers;

import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.service.AlunoService;
import br.edu.ifrs.poa.tcc.service.ProfessorService;
import br.edu.ifrs.poa.tcc.service.PropostaService;
import br.edu.ifrs.poa.tcc.service.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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
    
    @GetMapping("/delete/{id}")
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
