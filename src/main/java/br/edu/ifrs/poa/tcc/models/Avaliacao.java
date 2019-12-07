package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Aluno autor;
	
	@OneToOne
	private Proposta proposta;
	
	@ManyToOne
	private Professor orientador;

	public Avaliacao() {
		
	}
	
	
	
	

}
