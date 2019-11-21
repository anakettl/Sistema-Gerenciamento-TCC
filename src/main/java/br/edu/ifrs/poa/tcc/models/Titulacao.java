package br.edu.ifrs.poa.tcc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "titulos")
public class Titulacao extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany
	private List<Professor> professor;
	
	protected String Graduacao;
	protected String Especializacao;
	protected String Mestrado;
	protected String Doutorado;
	
	public Titulacao() {
		
	}
	
	public Titulacao(List<Professor> professor, String graduacao, String especializacao, String mestrado, String doutorado) {
		super();
		this.professor = professor;
		Graduacao = graduacao;
		Especializacao = especializacao;
		Mestrado = mestrado;
		Doutorado = doutorado;
	}
	
	public List<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}
	public String getGraduacao() {
		return Graduacao;
	}
	public void setGraduacao(String graduacao) {
		Graduacao = graduacao;
	}
	public String getEspecializacao() {
		return Especializacao;
	}
	public void setEspecializacao(String especializacao) {
		Especializacao = especializacao;
	}
	public String getMestrado() {
		return Mestrado;
	}
	public void setMestrado(String mestrado) {
		Mestrado = mestrado;
	}
	public String getDoutorado() {
		return Doutorado;
	}
	public void setDoutorado(String doutorado) {
		Doutorado = doutorado;
	}

	@Override
	public String toString() {
		return "Titulacao [professor=" + professor + ", Graduacao=" + Graduacao + ", Especializacao=" + Especializacao
				+ ", Mestrado=" + Mestrado + ", Doutorado=" + Doutorado + "]";
	}
	
	
}
