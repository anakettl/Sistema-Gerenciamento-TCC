package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "propostas")
public class Proposta extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String titulo;
	
	@OneToOne
	private Aluno autor;
	
	@ManyToOne
	private Professor orientador;

	public Proposta() {
		
	}
	
	public Proposta(String titulo, Aluno autor, Professor orientador) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.orientador = orientador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Aluno getAutor() {
		return autor;
	}

	public void setAutor(Aluno autor) {
		this.autor = autor;
	}

	public Professor getOrientador() {
		return orientador;
	}

	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}

	@Override
	public String toString() {
		return "PropostaTcc [titulo=" + titulo + ", autor=" + autor + ", orientador=" + orientador + ", id=" + id
				+ ", isNew()=" + isNew() + "]";
	}
	
	

}
