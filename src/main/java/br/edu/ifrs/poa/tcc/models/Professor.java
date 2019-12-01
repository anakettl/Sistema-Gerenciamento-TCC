package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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



}
