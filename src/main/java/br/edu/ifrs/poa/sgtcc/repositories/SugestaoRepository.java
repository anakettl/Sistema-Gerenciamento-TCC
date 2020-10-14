package br.edu.ifrs.poa.sgtcc.repositories;

import br.edu.ifrs.poa.sgtcc.models.Sugestao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Integer> {
    List<Sugestao> findAll();
    Optional<Sugestao> findById(Long id);
}
