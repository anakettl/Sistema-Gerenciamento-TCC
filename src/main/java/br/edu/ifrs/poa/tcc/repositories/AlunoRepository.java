package br.edu.ifrs.poa.tcc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.poa.tcc.models.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	Optional<Aluno> findById(Integer id);
}
