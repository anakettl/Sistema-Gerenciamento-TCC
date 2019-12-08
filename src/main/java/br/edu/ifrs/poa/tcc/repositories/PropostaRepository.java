package br.edu.ifrs.poa.tcc.repositories;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Integer> {


    List<Proposta> findAll();

    Optional<Proposta> findById(Integer id);

    Proposta findByAutor(Aluno autor);


}
