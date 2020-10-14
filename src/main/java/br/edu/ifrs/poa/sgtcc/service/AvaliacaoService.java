package br.edu.ifrs.poa.sgtcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.sgtcc.models.Avaliacao;
import br.edu.ifrs.poa.sgtcc.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacoes;

	public AvaliacaoService(AvaliacaoRepository avaliacoes) {
		super();
		this.avaliacoes = avaliacoes;
	}
	
	//CREATE
	public void salvar(Avaliacao avaliacao){
		try {
			this.avaliacoes.saveAndFlush(avaliacao);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar nova avaliacao", exception);
		}
	}
	
	//READ
	public Avaliacao avaliacao(Integer id){
		try {
			Optional<Avaliacao> avaliacao = this.avaliacoes.findById(id);
			if(avaliacao.isPresent()) return avaliacao.get();
			else throw new ServiceException("Nao foi possivel buscar a avaliacao");
		} catch (Exception exception) {
			throw new ServiceException("Erro, ", exception);
		}
	}
		
	//UPDATE
	public void atualizar(Avaliacao avaliacao){
		try {
			this.avaliacoes.saveAndFlush(avaliacao);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar nova avaliacao", exception);
		}
	}
	
	//DELETE
		public void excluir(Integer id){
			try {
				Optional<Avaliacao> avaliacao = this.avaliacoes.findById(id);
				if(avaliacao.isPresent()) this.avaliacoes.deleteById(avaliacao.get().getId());
				else throw new ServiceException("Nao foi possivel buscar a avaliacao");
			} catch (Exception exception) {
				throw new ServiceException("Nao foi possivel excluir a avaliacao", exception);
			}
		}
	
	//ALL
	public List<Avaliacao> todos(){
		try {
			return avaliacoes.findAll();
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todas avaliacoes", exception);
		}
	}
	
	//DELETE ALL
	public void excluirTodos(List<Avaliacao> lista){
		try {
			this.avaliacoes.deleteAll(lista);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todas avaliacoes", exception);
		}
	}
	
	
}
