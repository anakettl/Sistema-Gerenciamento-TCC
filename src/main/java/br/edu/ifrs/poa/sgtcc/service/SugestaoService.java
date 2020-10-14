package br.edu.ifrs.poa.sgtcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.sgtcc.models.Sugestao;
import br.edu.ifrs.poa.sgtcc.repositories.SugestaoRepository;

@Service
public class SugestaoService {

	@Autowired
	private SugestaoRepository sugestoes;

	public SugestaoService(SugestaoRepository sugestoes) {
		this.sugestoes = sugestoes;
	}
    public List<Sugestao> pegarSugestoes() {
        return sugestoes.findAll();
    }
    
    //CREATE
    public Sugestao salvar(Sugestao sugestao) {
        return sugestoes.save(sugestao);
    }

	//READ
	public Sugestao sugestao(Integer id){
		try {
			Optional<Sugestao> sugestao = this.sugestoes.findById(id);
			if(sugestao.isPresent()) return sugestao.get();
			else throw new ServiceException("Nao foi possivel buscar o sugestao");
		} catch (Exception exception) {
			throw new ServiceException("Erro, ", exception);
		}
	}

	//UPDATE
	public void atualizar(Sugestao sugestao){
		try {
			this.sugestoes.saveAndFlush(sugestao);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar novo sugestao", exception);
		}
	}

	//DELETE
		public void excluir(Integer id){
			try {
				Optional<Sugestao> sugestao = this.sugestoes.findById(id);
				if(sugestao.isPresent()) this.sugestoes.deleteById(sugestao.get().getId());
				else throw new ServiceException("Nao foi possivel buscar a sugestao");
			} catch (Exception exception) {
				throw new ServiceException("Nao foi possivel excluir a sugestao", exception);
			}
		}

	//ALL
	public List<Sugestao> todos(){
		try {
			return sugestoes.findAll();
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todas sugestoes", exception);
		}
	}

	//DELETE ALL
	public void excluirTodos(List<Sugestao> lista){
		try {
			this.sugestoes.deleteAll(lista);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todas sugestoes", exception);
		}
	}


}
