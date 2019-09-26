package br.edu.ifrs.poa.tcc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@NotBlank(message = "Nome obrigatório")
	@Column(length = 55, nullable = true)
	protected String name;

	@NotBlank(message = "Email obrigatório")
	@Email(message = "Email inválido")
	@Column(length = 80, nullable = true)
	protected String email;

	public Person() {

	}

	public Person(Integer id, @NotBlank(message = "Nome obrigatório") String name,
			@NotBlank(message = "Email obrigatório") @Email(message = "Email inválido") String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	protected Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", isNew()=" + isNew() + "]";
	}
	
}
