package br.edu.ifrs.poa.tcc.security.user.controller;

import br.edu.ifrs.poa.tcc.security.user.UsuarioLogado;
import br.edu.ifrs.poa.tcc.security.user.repositories.PapelRepository;
import br.edu.ifrs.poa.tcc.security.user.repositories.UsuarioLogadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private PapelRepository papeis;

    @Autowired
    private UsuarioLogadoRepository usuarios;

    @GetMapping("/create")
    public ModelAndView viewCadastroUsuario(UsuarioLogado usuario) {
        ModelAndView model = new ModelAndView("aluno/create");
        try {
            model.addObject("usuario", usuario);
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            model.setViewName("home");
            return model;
        }
    }

    @PostMapping("/create")
    public ModelAndView cadastroUsuario(@Valid UsuarioLogado usuario, @RequestParam("papel") String papel, BindingResult resultado, RedirectAttributes redirecionamento) {
        ModelAndView model = new ModelAndView("redirect:/home");
        try {
            if(resultado.hasErrors()) {
                return viewCadastroUsuario(usuario);
            }
            this.usuarios.saveAndFlush(usuario);
            redirecionamento.addFlashAttribute("message", "Usuario salvo");
            return model;
        } catch (Exception exception) {
            model.addObject("erro", exception.getMessage());
            return model;
        }
    }
}
