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

	@NotBlank(message = "Username obrigatório")
	@Column(length = 20,unique = true)
	protected String username;

	@NotBlank(message = "Senha obrigatório")
	@Column(length = 30)
	protected String password;

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
	
	public Pessoa() {
		
	}
	public Pessoa(Integer id, @NotBlank(message = "Nome obrigatório") String nome,
			@NotBlank(message = "Username obrigatório") String username,
			@NotBlank(message = "Senha obrigatório") String password,
			@NotBlank(message = "Email obrigatório") @Email(message = "Email inválido") String email,
			@NotBlank(message = "Telefone obrigatório") String telefone,
			@NotBlank(message = "Matrícula obrigatória") String matricula,
			@CPF(message = "CPF invalido") @NotBlank(message = "CPF obrigatório") String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telefone = telefone;
		this.matricula = matricula;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password + ", email="
				+ email + ", telefone=" + telefone + ", matricula=" + matricula + ", cpf=" + cpf + ", isNew()="
				+ isNew() + "]";
	}
	
}
