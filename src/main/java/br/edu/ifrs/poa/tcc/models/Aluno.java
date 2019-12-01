package br.edu.ifrs.poa.tcc.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alunos") // nome de tabela deve ser o nome da classe no plural em letras minusculas
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	private Proposta proposta;

	public Aluno() {

	}

	public Aluno(String nome, String email, String telefone, String matricula, String cpf) {
		super(nome, email, telefone, matricula, cpf);
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"proposta=" + proposta +
				", id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", telefone='" + telefone + '\'' +
				", matricula='" + matricula + '\'' +
				", cpf='" + cpf + '\'' +
				'}';
	}
}
