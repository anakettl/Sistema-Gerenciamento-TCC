package br.edu.ifrs.poa.tcc.controllers;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.service.ProfessorService;
import br.edu.ifrs.poa.tcc.service.PropostaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/propostas")
public class PropostaController {

    private PropostaService propostaService;
    private ProfessorService professorService;

    public PropostaController(PropostaService propostaService, ProfessorService professorService) {
        this.propostaService = propostaService;
        this.professorService = professorService;
    }

    @GetMapping("/create")
    public String criarProposta(Model model) {
        model.addAttribute("professores", professorService.pegarProfessores());
        model.addAttribute("proposta", new Proposta());
        return "proposta/create";
    }

    @PostMapping("/create")
    public String salvarProposta(Proposta proposta, BindingResult resultadoValidacao, Model model, RedirectAttributes redirecionamentoDeAtributos) {

        if (resultadoValidacao.hasErrors()) {
            model.addAttribute("erros", resultadoValidacao.getAllErrors());
            model.addAttribute("professores", professorService.pegarProfessores());

            return "proposta/create";
        }

        propostaService.salvar(proposta);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Proposta criada com sucesso!");

        return "redirect:/propostas";
    }

    @GetMapping
    public String PropostasCriadas(Model model) {

        model.addAttribute("propostasCriadas", propostaService.pegarPropostas());

        return "proposta/read";
    }

    @GetMapping("/proposta")
    public String proposta(Proposta proposta, Aluno aluno, Model model) {
        try {
            Proposta p = this.propostaService.buscarPropostaPeloAluno(aluno);
            model.addAttribute("proposta", p);
            return "proposta/show";
        } catch (Exception exception) {
            return "/";
        }
    }

}
