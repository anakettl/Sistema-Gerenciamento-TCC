package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Entity
@Table(name = "SUGESTOES")
@SequenceGenerator(name = "SEQUENCE_SUGESTOES", allocationSize = 1)
public class Sugestao {

	@Id
	@GeneratedValue(generator = "SEQUENCE_SUGESTOES", strategy = GenerationType.TABLE)
	private Integer id;

	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private boolean pesquisa;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "FK_PROFESSOR_UID")
	private Professor professor;

}
