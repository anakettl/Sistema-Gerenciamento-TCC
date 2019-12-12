package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sugestoes")
public class Sugestao extends BaseEntity {
private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private Boolean pesquisa;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	private Professor orientador;
	
	
	public Sugestao(String titulo, Boolean pesquisa, String descricao, Professor orientador) {
		super();
		this.titulo = titulo;
		this.pesquisa = pesquisa;
		this.descricao = descricao;
		this.orientador = orientador;
	}
	
	
	public Sugestao() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Boolean pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }
	

}
