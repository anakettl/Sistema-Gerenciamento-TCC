package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Pessoa implements Serializable {

	@NotBlank(message = "Nome obrigatório")
	@Column(length = 55, nullable = false)
	protected String nome;

	@NotBlank(message = "Email obrigatório")
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
}
