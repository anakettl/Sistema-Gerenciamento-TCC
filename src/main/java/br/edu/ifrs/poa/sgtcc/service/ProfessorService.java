package br.edu.ifrs.poa.sgtcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.poa.sgtcc.models.Professor;
import br.edu.ifrs.poa.sgtcc.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professores;

	public ProfessorService(ProfessorRepository professores) {
		super();
		this.professores = professores;
	}
    public List<Professor> pegarProfessores() {
        return professores.findAll();
    }
	//CREATE
	public void salvar(Professor professor){
		try {
			this.professores.saveAndFlush(professor);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar novo professor", exception);
		}
	}

	//READ
	public Professor professor(Integer id){
		try {
			Optional<Professor> professor = this.professores.findById(id);
			if(professor.isPresent()) return professor.get();
			else throw new ServiceException("Nao foi possivel buscar o professor");
		} catch (Exception exception) {
			throw new ServiceException("Erro, ", exception);
		}
	}

	//UPDATE
	public void atualizar(Professor professor){
		try {
			this.professores.saveAndFlush(professor);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel salvar novo professor", exception);
		}
	}

	//DELETE
		public void excluir(Integer id){
			try {
				Optional<Professor> professor = this.professores.findById(id);
				if(professor.isPresent()) this.professores.deleteById(professor.get().getId());
				else throw new ServiceException("Nao foi possivel buscar o professor");
			} catch (Exception exception) {
				throw new ServiceException("Nao foi possivel excluir o professor", exception);
			}
		}

	//ALL
	public List<Professor> todos(){
		try {
			return professores.findAll();
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todos professores", exception);
		}
	}

	//DELETE ALL
	public void excluirTodos(List<Professor> lista){
		try {
			this.professores.deleteAll(lista);
		} catch (Exception exception) {
			throw new ServiceException("Nao foi possivel buscar todos professores", exception);
		}
	}


}
