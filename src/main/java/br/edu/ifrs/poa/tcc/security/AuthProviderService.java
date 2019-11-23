package br.edu.ifrs.poa.tcc.security;

import br.edu.ifrs.poa.tcc.dto.AutDto;
import br.edu.ifrs.poa.tcc.models.Categoria;
import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.repositories.AlunoRepository;;


@Service
public class AuthProviderService implements UserDetailsService{
	
	@Autowired
	AlunoRepository repositoryA;

	@Autowired
	ProfessorRepository repositoryP;
	
	@Override
	public UserDetails loadUserByUsername(String user){
		AutDto usuario = user;
		if(usuario.getTipo().equals(Categoria.ALUNO)){
			Aluno aluno = repositoryA.findByUsername(usuario.getUsername());
			return  aluno;
		} else if (usuario.getTipo().equals(Categoria.PROFESSOR)){
			Professor professor = repositoryP.findByUsername(usuario.getUsername());
			return professor;
		}else if (usuario.getTipo().equals(Categoria.ADMIN)){

		} else throw new UsernameNotFoundException("Dados Inválidos");
	}

}