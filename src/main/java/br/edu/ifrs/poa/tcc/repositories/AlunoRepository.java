package br.edu.ifrs.poa.tcc.repositories;

import br.edu.ifrs.poa.tcc.models.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findById(Integer id);
}
