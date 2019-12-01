package br.edu.ifrs.poa.tcc.security.user.repositories;

import br.edu.ifrs.poa.tcc.security.user.Categoria;
import br.edu.ifrs.poa.tcc.security.user.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {
    List<Papel> findByGrupo(Categoria grupo);
}
