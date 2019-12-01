package br.edu.ifrs.poa.tcc.repositories;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

    //sempre depois do findby vai o nome do atributo que deve ser encontrado
    Proposta findByAutor(Aluno autor);

    List<Proposta> findAll();


}
