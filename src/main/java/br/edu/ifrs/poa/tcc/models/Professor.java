package br.edu.ifrs.poa.tcc.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "professores")
@SequenceGenerator(name = "SEQUENCE_PROFESSOR", initialValue = 1, allocationSize = 1)
public class Professor extends Pessoa{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQUENCE_PROFESSOR", strategy = GenerationType.TABLE)
	private Integer id;

	@ManyToOne
	private Titulacao titulo;

	@OneToMany
	private List<SugestaoProjeto> sugestaoProjeto;

	@OneToMany
	private List<AreaInteresse> areaInteresse;

	public Professor() {

	}

	public Professor(String nome, String email, String telefone, String matricula, String cpf) {
		super(nome, email, telefone, matricula, cpf);
	}

	public Professor(Titulacao titulo, List<SugestaoProjeto> sugestaoProjeto) {
		super();
		this.titulo = titulo;
		this.sugestaoProjeto = sugestaoProjeto;
	}

	public Integer getId() {
		return id;
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
