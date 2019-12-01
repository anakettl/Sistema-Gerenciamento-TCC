package br.edu.ifrs.poa.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.repositories.PropostaRepository;

@Service
public class PropostaService {
	
	@Autowired
	private PropostaRepository proposta;

	public PropostaService(PropostaRepository proposta) {
		this.proposta = proposta;
	}

	public void salvar(Proposta proposta){
		try {
			this.proposta.saveAndFlush(proposta);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar uma nova proposta", exception);
		}
	}

	public Proposta buscarPropostaPeloAluno(Aluno aluno) {
		try {
			return this.proposta.findByAutor(aluno);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}
	
}
