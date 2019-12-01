package br.edu.ifrs.poa.tcc.service;

import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }
    public List<Professor> pegarProfessores() {
        return repository.findAll();
    }
}
