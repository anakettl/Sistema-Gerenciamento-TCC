package br.edu.ifrs.poa.sgtcc.repositories;

import br.edu.ifrs.poa.sgtcc.models.Avaliacao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
	Optional<Avaliacao> findById(Integer id);
}
