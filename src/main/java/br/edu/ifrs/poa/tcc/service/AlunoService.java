package br.edu.ifrs.poa.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.tcc.models.Aluno;
import br.edu.ifrs.poa.tcc.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunos;

	public AlunoService(AlunoRepository alunos) {
		super();
		this.alunos = alunos;
	}
	
	//CREATE
	public void salvar(Aluno aluno){
		try {
			this.alunos.saveAndFlush(aluno);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar novo aluno", exception);
		}
	}
	
	//READ
	public Aluno aluno(Integer id){
		try {
			Optional<Aluno> aluno = this.alunos.findById(id);
			if(aluno.isPresent()) return aluno.get();
			else throw new ServiceException("Nao foi possivel buscar o aluno");
		} catch (Exception exception) {
			throw new ServiceException("Erro, ", exception);
		}
	}
		
	//UPDATE
	public void atualizar(Aluno aluno){
		try {
			this.alunos.saveAndFlush(aluno);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar novo aluno", exception);
		}
	}
	
	//DELETE
		public void excluir(Integer id){
			try {
				Optional<Aluno> aluno = this.alunos.findById(id);
				if(aluno.isPresent()) this.alunos.deleteById(aluno.get().getId());
				else throw new ServiceException("Nao foi possivel buscar o aluno");
			} catch (Exception exception) {
				throw new ServiceException("Nao foi possivel excluir o aluno", exception);
			}
		}
	
	//ALL
	public List<Aluno> todos(){
		try {
			return alunos.findAll();
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todos alunos", exception);
		}
	}
	
	//DELETE ALL
	public void excluirTodos(List<Aluno> lista){
		try {
			this.alunos.deleteAll(lista);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todos alunos", exception);
		}
	}
	
	
}
