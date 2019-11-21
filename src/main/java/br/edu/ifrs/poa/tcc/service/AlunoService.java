package br.edu.ifrs.poa.tcc.service;

import java.util.List;

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
	public Aluno aluno(Long matricula){
		try {
			return this.alunos.findByMatricula(matricula);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar o aluno", exception);
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
		public void excluir(Long matricula){
			try {
				Aluno aluno = this.alunos.findByMatricula(matricula);
				this.alunos.delete(aluno);
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
