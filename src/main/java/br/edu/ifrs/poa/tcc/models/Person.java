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
public class Person implements Serializable {
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
	protected Long telefone;
	
	@NotBlank(message = "Matrícula obrigatória")
	@Column(length = 80, nullable = false)
	protected Long matricula;
	
	@CPF(message = "CPF invalido")
	@NotBlank(message = "CPF obrigatório")
	@Column(length = 80, nullable = false)
	protected String cpf;

	public Person() {

	}

	public Person(Integer id, @NotBlank(message = "Nome obrigatório") String nome,
			@NotBlank(message = "Email obrigatório") @Email(message = "Email inválido") String email,
			@NotBlank(message = "Telefone obrigatório") Long telefone,
			@NotBlank(message = "Matrícula obrigatória") Long matricula,
			@CPF(message = "CPF invalido") @NotBlank(message = "CPF obrigatório") String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.matricula = matricula;
		this.cpf = cpf;
	}

	protected Integer getId() {
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
	
	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + nome + ", email=" + email + ", telefone=" + telefone + ", matricula="
				+ matricula + ", cpf=" + cpf + ", getCpf()=" + getCpf() + ", getId()=" + getId() + ", getName()="
				+ getNome() + ", getEmail()=" + getEmail() + ", getTelefone()=" + getTelefone() + ", getMatricula()="
				+ getMatricula() + ", isNew()=" + isNew() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
