package br.edu.ifrs.poa.tcc.security;

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
	AlunoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String user){
		Aluno usuario = repository.findByMatricula(Long.parseLong(user));
		if(!usuario.isNew()){return usuario.}
		else {throw new UsernameNotFoundException("Dados Inválidos");}
	}

}