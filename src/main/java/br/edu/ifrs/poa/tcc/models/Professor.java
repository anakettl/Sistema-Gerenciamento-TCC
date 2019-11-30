package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor extends Pessoa{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Titulacao titulo;



}
