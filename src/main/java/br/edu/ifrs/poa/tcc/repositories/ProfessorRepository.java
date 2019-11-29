package br.edu.ifrs.poa.tcc.repositories;

import br.edu.ifrs.poa.tcc.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Professor findByUsername(String username);
}
