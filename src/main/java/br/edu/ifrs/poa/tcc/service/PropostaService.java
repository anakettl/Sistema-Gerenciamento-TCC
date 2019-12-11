package br.edu.ifrs.poa.tcc.service;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.models.Professor;
import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostas;

    public PropostaService(PropostaRepository propostas) {
        this.propostas = propostas;
    }

    public Proposta salvar(Proposta proposta) {
        return propostas.save(proposta);
    }

    public List<Proposta> pegarPropostas() {
        return propostas.findAll();
    }

    public Proposta encontraUma(Integer id) {
        return propostas
                .findById(id).get();
    }
//    public void remover(Integer id) {
//        repository.deleteById(id);
//    }
    
    public void excluir(Integer id){
		try {
			Optional<Proposta> proposta = this.propostas.findById(id);
			if(proposta.isPresent()) this.propostas.deleteById(proposta.get().getId());
			else throw new ServiceException("Nao foi possivel buscar a proposta");
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel excluir a proposta", exception);
		}
	}



    public Proposta buscarPropostaPeloAluno(Aluno aluno) {
        try {
            return this.propostas.findByAutor(aluno);
        } catch (Exception exception) {
            throw new ServiceException(exception);
        }
    }
    
    public List<Proposta> todos(){
		try {
			return propostas.findAll();
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todos professores", exception);
		}
	}

}
