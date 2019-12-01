package br.edu.ifrs.poa.tcc.security.user.controller;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.repositories.AlunoRepository;
import br.edu.ifrs.poa.tcc.repositories.ProfessorRepository;
import br.edu.ifrs.poa.tcc.security.user.CadastroDto;
import br.edu.ifrs.poa.tcc.security.user.Categoria;
import br.edu.ifrs.poa.tcc.security.user.Papel;
import br.edu.ifrs.poa.tcc.security.user.UsuarioLogado;
import br.edu.ifrs.poa.tcc.security.user.repositories.PapelRepository;
import br.edu.ifrs.poa.tcc.security.user.repositories.UsuarioLogadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/signup")
public class UsuarioController {

    @Autowired
    private PapelRepository papeis;

    @Autowired
    private UsuarioLogadoRepository usuarios;

    @Autowired
    private AlunoRepository alunos;

    @Autowired
    private ProfessorRepository professores;

    @GetMapping
    public ModelAndView viewCadastroUsuario(CadastroDto cadastro) {
        ModelAndView model = new ModelAndView("security/signup");
        try {
            List<Categoria> categorias = Arrays.asList(Categoria.ALUNO,Categoria.PROFESSOR);
            model.addObject("categorias", categorias);
            model.addObject("cadastro", cadastro);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("security/index");
            return model;
        }
    }

    @PostMapping
    public ModelAndView cadastroUsuario(@Valid CadastroDto cadastro, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("redirect:/login");
        try {
            if(resultado.hasErrors()) {
                return viewCadastroUsuario(cadastro);
            }
            if (cadastro.getCategoria() == Categoria.ALUNO){
                List<Papel> papeis = this.papeis.findByGrupo(Categoria.ALUNO);
                UsuarioLogado usuario = new UsuarioLogado(cadastro.getUsername(), new BCryptPasswordEncoder().encode(cadastro.getPassword()), papeis);
                Aluno aluno = new Aluno(cadastro.getNome(), cadastro.getEmail(), cadastro.getTelefone(), cadastro.getMatricula(), cadastro.getCpf());

                this.usuarios.saveAndFlush(usuario);
                this.alunos.saveAndFlush(aluno);
            } else if (cadastro.getCategoria() == Categoria.PROFESSOR){
                List<Papel> papeis = this.papeis.findByGrupo(Categoria.PROFESSOR);
                UsuarioLogado usuario = new UsuarioLogado(cadastro.getUsername(), new BCryptPasswordEncoder().encode(cadastro.getPassword()), papeis);
                Professor professor = new Professor(cadastro.getNome(), cadastro.getEmail(), cadastro.getTelefone(), cadastro.getMatricula(), cadastro.getCpf());

                this.usuarios.saveAndFlush(usuario);
                this.professores.saveAndFlush(professor);
            }

            redirecionamento.addFlashAttribute("message", "Usuario salvo");
            return new ModelAndView(new RedirectView("/login", false));
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            return model;
        }
    }
}
