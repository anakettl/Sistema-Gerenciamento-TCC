package br.edu.ifrs.poa.tcc.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioLogin, String>{
	UsuarioLogin findByLogin(String login);
}
