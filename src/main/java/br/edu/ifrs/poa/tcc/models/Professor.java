package br.edu.ifrs.poa.tcc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor extends Pessoa{
	
	private static final long serialVersionUID = 1L;

	public Professor() {

	}
	public Professor(String nome, String email, String telefone, String matricula, String cpf) {
		super(nome, email, telefone, matricula, cpf);
	}

	@ManyToOne
	private Titulacao titulo;
	
	@OneToMany
	private List<SugestaoProjeto> sugestaoProjeto;
	
	@OneToMany
	private List<AreaInteresse> areaInteresse;
	
	
	public Professor(Titulacao titulo, List<SugestaoProjeto> sugestaoProjeto) {
		super();
		this.titulo = titulo;
		this.sugestaoProjeto = sugestaoProjeto;
	}
	
	public Professor() {
		
	}

	public Titulacao getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulacao titulo) {
		this.titulo = titulo;
	}

	public List<SugestaoProjeto> getSugestaoProjeto() {
		return sugestaoProjeto;
	}

	public void setSugestaoProjeto(List<SugestaoProjeto> sugestaoProjeto) {
		this.sugestaoProjeto = sugestaoProjeto;
	}



}
