package br.edu.ifrs.poa.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrs.poa.tcc.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	Aluno findByMatricula(Long matricula);
	Aluno findByUsername(String username);
	
}
