package br.edu.ifrs.poa.tcc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@MappedSuperclass
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@NotBlank(message = "Nome obrigatório")
	@Column(length = 55, nullable = false)
	protected String nome;

	@NotBlank(message = "Email obrigatório")
	@Email(message = "Email inválido")
	@Column(length = 80, nullable = false)
	protected String email;
	
	@NotBlank(message = "Telefone obrigatório")
	@Column(length = 30)
	protected String telefone;
	
	@NotBlank(message = "Matrícula obrigatória")
	@Column(length = 80, nullable = false)
	protected String matricula;
	
	@NotBlank(message = "CPF obrigatório")
	@Column(length = 80, nullable = false)
	protected String cpf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", matricula="
				+ matricula + ", cpf=" + cpf + "]";
	}

	
	
}
