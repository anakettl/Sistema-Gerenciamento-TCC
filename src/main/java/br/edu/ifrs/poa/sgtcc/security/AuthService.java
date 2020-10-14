package br.edu.ifrs.poa.sgtcc.security;

import br.edu.ifrs.poa.sgtcc.security.user.UsuarioLogado;
import br.edu.ifrs.poa.sgtcc.security.user.repositories.UsuarioLogadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	UsuarioLogadoRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String user){
		Optional<UsuarioLogado> usuario = repositorio.findByUsername(user);
		if(usuario.isPresent())	{return usuario.get();}
		else {throw new UsernameNotFoundException("Dados Inválidos");}
	}

}


