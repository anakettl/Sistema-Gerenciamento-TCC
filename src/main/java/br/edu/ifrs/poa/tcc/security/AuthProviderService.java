package br.edu.ifrs.poa.tcc.security;

import br.edu.ifrs.poa.tcc.repositories.AlunoRepository;
import br.edu.ifrs.poa.tcc.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthProviderService implements UserDetailsService, AuthenticationProvider {
	
	@Autowired
	AlunoRepository repositoryA;

	@Autowired
	ProfessorRepository repositoryP;
	
	@Override
	public UserDetails loadUserByUsername(String user){
		throw new UsernameNotFoundException("Dados Inválidos");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}
}