package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD:src/main/java/br/edu/ifrs/poa/tcc/models/Professor.java
@Table(name = "teachers")
public class Professor extends Person{
=======
@Table(name = "professores")
public class Professor extends Pessoa{
>>>>>>> master:src/main/java/br/edu/ifrs/poa/tcc/models/Professor.java
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Titulacao titulo;

}
