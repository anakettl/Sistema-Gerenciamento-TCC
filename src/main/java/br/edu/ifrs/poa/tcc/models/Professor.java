package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Professor extends Person{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Titulacao titulo;

}
