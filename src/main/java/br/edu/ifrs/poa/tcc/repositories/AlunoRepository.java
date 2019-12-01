package br.edu.ifrs.poa.tcc.repositories;

import br.edu.ifrs.poa.tcc.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findById(Integer id);
}
