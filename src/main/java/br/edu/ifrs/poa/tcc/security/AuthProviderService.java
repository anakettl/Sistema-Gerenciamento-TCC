package br.edu.ifrs.poa.tcc.security;

import br.edu.ifrs.poa.tcc.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.repositories.AlunoRepository;;


@Service
public class AuthenticateService implements UserDetailsService{
	
	@Autowired
	AlunoRepository repositoryA;

	@Autowired
	ProfessorRepository repositoryP
	
	@Override
	public UserDetails loadUserByUsername(String user){
		Object usuario = repositoryA.findByMatricula(Long.parseLong(user));
		if(!usuario.isNew()){return usuario.}
		else {throw new UsernameNotFoundException("Dados Inválidos");}
	}

}