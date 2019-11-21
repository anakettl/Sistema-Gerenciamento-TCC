package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students") // nome de tabela deve ser o nome da classe no plural em letras minusculas
public class Student extends Person {
	private static final long serialVersionUID = 1L;
	
	public Student() {
		
	}
	
	@OneToOne
	private Proposta proposta;

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}
	

}
