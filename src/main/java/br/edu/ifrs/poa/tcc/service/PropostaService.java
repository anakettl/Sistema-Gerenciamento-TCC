package br.edu.ifrs.poa.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.repositories.PropostaRepository;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository repository;

    public PropostaService(PropostaRepository repository) {
        this.repository = repository;
    }

    public Proposta salvar(Proposta proposta) {
        return repository.save(proposta);
    }

    public Proposta buscarPropostaPeloAluno(Aluno aluno) {
        try {
            return this.repository.findByAutor(aluno);
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }

}
