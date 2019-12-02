package br.edu.ifrs.poa.tcc.service;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Proposta> pegarPropostas() {
        return repository.findAll();
    }

    public Proposta encontraUma(Long id) {
        return repository
                .findById(id).get();
    }
    public void remover(Integer id) {
        repository.deleteById(id);
    }



    public Proposta buscarPropostaPeloAluno(Aluno aluno) {
        try {
            return this.repository.findByAutor(aluno);
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }

}
