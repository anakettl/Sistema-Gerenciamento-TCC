package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BANCAS")
@SequenceGenerator(name = "SEQUENCE_BANCAS", allocationSize = 1)
public class Banca {

	@Id
	@GeneratedValue(generator = "SEQUENCE_BANCAS", strategy = GenerationType.TABLE)
	private Integer id;

	@NotBlank(message = "Aluno é obrigatório")
	@ManyToOne
	@JoinColumn(name = "FK_ALUNO_UID")
	private Aluno aluno;

	@OneToOne
	@JoinColumn(name = "FK_PROPOSTA_UID")
	private Proposta proposta;
	
	@NotBlank(message = "Orientador é obrigatório")
	@ManyToOne
	@JoinColumn(name = "FK_ORIENTADOR_UID")
	private Professor orientador;

	@NotBlank(message = "Avaliadores são obrigatórios")
	@ManyToMany
	@JoinTable(
			name = "BANCAS_AVALIADORES",
			joinColumns = @JoinColumn(name = "FK_BANCA_UID"),
			inverseJoinColumns = @JoinColumn(name = "FK_AVALIADOR_UID"))
	private List<Professor> professores;
	
	@NotBlank(message = "Data é obrigatório")
	@Column(length = 55, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMarcada;
	
	@NotBlank(message = "Hora é obrigatório")
	@Column(length = 55, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;

}
