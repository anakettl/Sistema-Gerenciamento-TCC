package br.edu.ifrs.poa.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Proposta;
import br.edu.ifrs.poa.tcc.models.Student;
import br.edu.ifrs.poa.tcc.repositories.PropostaRepository;

@Service
public class PropostaService {
	
	@Autowired
	private PropostaRepository proposta;

	public PropostaService(PropostaRepository proposta) {
		this.proposta = proposta;
	}
	
	public Proposta buscarPropostaPeloAluno(Student aluno) {
		try {
			return this.proposta.findByStudent(aluno);
		} catch (Exception exception) {
			throw new ServiceException(exception);
		}
	}
	
}
