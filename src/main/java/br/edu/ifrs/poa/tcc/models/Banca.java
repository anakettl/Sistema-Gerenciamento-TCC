package br.edu.ifrs.poa.tcc.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "bancas")
public class Banca extends BaseEntity {
	
private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Aluno é obrigatório")
	@OneToOne(cascade = CascadeType.ALL)
	private Aluno autor;

//	@OneToOne
//	private Proposta proposta;
	
	@NotBlank(message = "Orientador é obrigatório")
	@ManyToOne
	private Professor orientador;
	
	@NotBlank(message = "Avaliador 1 é obrigatório")
	@ManyToOne
	private Professor avaliador1;
	
	@NotBlank(message = "Avaliador 2 obrigatório")
	@ManyToOne
	private Professor avaliador2;
	
	@NotBlank(message = "Data é obrigatório")
	@Column(length = 55, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@NotBlank(message = "Hora é obrigatório")
	@Column(length = 55, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date hora;


	public Aluno getAutor() {
		return autor;
	}

	public void setAutor(Aluno autor) {
		this.autor = autor;
	}

//	public Proposta getProposta() {
//		return proposta;
//	}
//
//	public void setProposta(Proposta proposta) {
//		this.proposta = proposta;
//	}

	public Professor getOrientador() {
		return orientador;
	}

	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}

	public Professor getAvaliador1() {
		return avaliador1;
	}

	public void setAvaliador1(Professor avaliador1) {
		this.avaliador1 = avaliador1;
	}

	public Professor getAvaliador2() {
		return avaliador2;
	}

	public void setAvaliador2(Professor avaliador2) {
		this.avaliador2 = avaliador2;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
}
