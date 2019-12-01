package br.edu.ifrs.poa.tcc.security.user.repositories;

import br.edu.ifrs.poa.tcc.security.user.Categoria;
import br.edu.ifrs.poa.tcc.security.user.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PapelRepository extends JpaRepository<Papel, Integer> {
    List<Papel> findByGrupo(Categoria aluno);
}
