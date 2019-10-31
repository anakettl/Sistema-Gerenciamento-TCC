package br.edu.ifrs.poa.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Student;

public interface PropostaRepository extends JpaRepository<Proposta, Integer>{
	Proposta findByStudent(Student aluno);
}