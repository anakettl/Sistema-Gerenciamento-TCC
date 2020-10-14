package br.edu.ifrs.poa.sgtcc.repositories;

import br.edu.ifrs.poa.sgtcc.models.Titulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TitulacaoRepository extends JpaRepository<Titulacao, Integer> {
    Optional<Titulacao> findById(Integer id);
}
