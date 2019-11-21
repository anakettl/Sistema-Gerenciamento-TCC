package br.edu.ifrs.poa.tcc.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunos") // nome de tabela deve ser o nome da classe no plural em letras minusculas
public class Aluno extends Person {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	private Proposta proposta;

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

}
