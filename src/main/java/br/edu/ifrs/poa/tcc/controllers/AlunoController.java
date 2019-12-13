package br.edu.ifrs.poa.tcc.controllers;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/alunos")
public class AlunoController {

    private AlunoService alunos;

    public AlunoController(AlunoService alunos) {
        super();
        this.alunos = alunos;
    }

    @GetMapping("/create")
    public ModelAndView viewSalvar(Aluno aluno) {
        ModelAndView model = new ModelAndView("aluno/create");
        try {
            model.addObject("aluno", aluno);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("welcome");
            return model;
        }
    }

    @PostMapping("/create")
    public ModelAndView salvar(@Valid Aluno aluno, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("redirect:/alunos");
        try {
            if (resultado.hasErrors()) {
                return viewSalvar(aluno);
            }
            this.alunos.salvar(aluno);
            redirecionamento.addFlashAttribute("message", "Aluno salvo com sucesso!");
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            return model;
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

    @GetMapping("/{id}")
    public ModelAndView ver(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("aluno/create");
        try {
            Aluno aluno = this.alunos.aluno(id);
            model.addObject("aluno", aluno);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("aluno/index");
            return model;
        }
    }
    
    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("redirect:/alunos");
        try {
        	this.alunos.excluir(id);
            model.addObject("alunos", this.alunos.todos());
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("aluno/index");
            return model;
        }
    }




}
