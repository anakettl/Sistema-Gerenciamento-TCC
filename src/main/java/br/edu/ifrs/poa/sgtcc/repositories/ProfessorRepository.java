package br.edu.ifrs.poa.sgtcc.repositories;

import br.edu.ifrs.poa.sgtcc.models.Professor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findAll();
    Optional<Professor> findById(Long id);
}
