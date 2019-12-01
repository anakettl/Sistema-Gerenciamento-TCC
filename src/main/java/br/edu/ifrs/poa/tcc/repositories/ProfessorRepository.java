package br.edu.ifrs.poa.tcc.repositories;

import br.edu.ifrs.poa.tcc.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Override
    List<Professor> findAll();


}
