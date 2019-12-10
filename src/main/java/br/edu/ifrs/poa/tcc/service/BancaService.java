package br.edu.ifrs.poa.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Banca;
import br.edu.ifrs.poa.tcc.repositories.BancaRepository;

@Service
public class BancaService {
	
	@Autowired
	private BancaRepository bancas;

	public BancaService(BancaRepository bancas) {
		super();
		this.bancas = bancas;
	}
	
	//CREATE
	public void salvar(Banca banca){
		try {
			this.bancas.saveAndFlush(banca);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar nova banca", exception);
		}
	}
	
	//READ
	public Banca banca(Integer id){
		try {
			Optional<Banca> banca = this.bancas.findById(id);
			if(banca.isPresent()) return banca.get();
			else throw new ServiceException("Nao foi possivel buscar a banca");
		} catch (Exception exception) {
			throw new ServiceException("Erro, ", exception);
		}
	}
		
	//UPDATE
	public void atualizar(Banca banca){
		try {
			this.bancas.saveAndFlush(banca);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar nova banca", exception);
		}
	}
	
	//DELETE
		public void excluir(Integer id){
			try {
				Optional<Banca> banca = this.bancas.findById(id);
				if(banca.isPresent()) this.bancas.deleteById(banca.get().getId());
				else throw new ServiceException("Nao foi possivel buscar a banca");
			} catch (Exception exception) {
				throw new ServiceException("Nao foi possivel excluir a banca", exception);
			}
		}
	
	//ALL
	public List<Banca> todos(){
		try {
			return bancas.findAll();
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todas bancas", exception);
		}
	}
	
	//DELETE ALL
	public void excluirTodos(List<Banca> lista){
		try {
			this.bancas.deleteAll(lista);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todas bancas", exception);
		}
	}
	
	
}
