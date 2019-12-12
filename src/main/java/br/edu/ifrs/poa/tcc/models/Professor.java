package br.edu.ifrs.poa.tcc.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "professores")
@SequenceGenerator(name = "SEQUENCE_PROFESSOR", initialValue = 1, allocationSize = 1)
public class Professor extends Pessoa{

	private static final long serialVersionUID = 1L;

	public Professor() {

	}

	public Integer getId() {
		return id;
	}

	public Professor(String nome, String email, String telefone, String matricula, String cpf) {
		super(nome, email, telefone, matricula, cpf);
	}

	public Professor(Titulacao titulo, List<Sugestao> sugestao) {
		super();
		this.titulo = titulo;
		this.sugestao = sugestao;
	}

	@Id
	@GeneratedValue(generator = "SEQUENCE_PROFESSOR", strategy = GenerationType.TABLE)
	private Integer id;

	@ManyToOne
	private Titulacao titulo;

	@OneToMany
	private List<Sugestao> sugestao;

	@OneToMany
	private List<AreaInteresse> areaInteresse;

	public Titulacao getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulacao titulo) {
		this.titulo = titulo;
	}

	public List<Sugestao> getsugestao() {
		return sugestao;
	}

	public void setSugestaoProjeto(List<Sugestao> sugestao) {
		this.sugestao = sugestao;
	}



}
