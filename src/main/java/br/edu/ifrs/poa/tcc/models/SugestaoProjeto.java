package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sugestoes_proposta")
public class SugestaoProjeto extends BaseEntity{
	
private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private Boolean pesquisa;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	private Professor orientador;
	
	
	public SugestaoProjeto(String titulo, Boolean pesquisa, String descricao) {
		super();
		this.titulo = titulo;
		this.pesquisa = pesquisa;
		this.descricao = descricao;
	}
	
	
	public SugestaoProjeto() {
		
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
	

}
