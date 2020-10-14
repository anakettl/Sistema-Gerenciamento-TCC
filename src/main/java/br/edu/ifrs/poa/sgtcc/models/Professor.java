package br.edu.ifrs.poa.sgtcc.models;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PROFESSORES")
@SequenceGenerator(name = "SEQUENCE_PROFESSORES", allocationSize = 1)
public class Professor extends Pessoa {

	@Id
	@GeneratedValue(generator = "SEQUENCE_PROFESSORES", strategy = GenerationType.TABLE)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "FK_TITULO_UID")
	private Titulacao titulo;

	@OneToMany(mappedBy = "orientador")
	private List<Proposta> propostas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
	private List<Sugestao> sugestoes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
	private List<AreaInteresse> areasInteresse;

	public Professor(@NotBlank(message = "Nome obrigatório") String nome,
					 @NotBlank(message = "Email obrigatório") String email,
					 @NotBlank(message = "Telefone obrigatório") String telefone,
					 @NotBlank(message = "Matrícula obrigatória") String matricula,
					 @NotBlank(message = "CPF obrigatório") String cpf,
					 Integer id, Titulacao titulo,
					 List<Sugestao> sugestoes,
					 List<AreaInteresse> areasInteresse) {
		super(nome, email, telefone, matricula, cpf);
		this.id = id;
		this.titulo = titulo;
		this.sugestoes = sugestoes;
		this.areasInteresse = areasInteresse;
	}
}
