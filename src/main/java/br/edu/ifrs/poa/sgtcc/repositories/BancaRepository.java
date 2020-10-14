package br.edu.ifrs.poa.sgtcc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.poa.sgtcc.models.Banca;

public interface BancaRepository extends JpaRepository<Banca, Integer> {
	Optional<Banca> findById(Integer id);
}
