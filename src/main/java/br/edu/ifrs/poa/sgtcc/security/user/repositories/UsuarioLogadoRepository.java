package br.edu.ifrs.poa.sgtcc.security.user.repositories;

import java.util.Optional;

import br.edu.ifrs.poa.sgtcc.security.user.UsuarioLogado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioLogadoRepository extends JpaRepository<UsuarioLogado, Integer> {

	Optional<UsuarioLogado> findByUsername(String user);

}
