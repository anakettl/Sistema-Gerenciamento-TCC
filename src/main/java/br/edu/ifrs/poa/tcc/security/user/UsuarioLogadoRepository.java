package br.edu.ifrs.poa.tcc.security.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioLogadoRepository extends JpaRepository<UsuarioLogado, Integer> {

	Optional<UsuarioLogado> findByUsername(String user);

}
