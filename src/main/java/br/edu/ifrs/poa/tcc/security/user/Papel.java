package br.edu.ifrs.poa.tcc.security.user;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "PAPEL")
@SequenceGenerator(name = "SEQUENCE_PAPEL", initialValue = 1, allocationSize = 1)
public class Papel implements  GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQUENCE_PAPEL", strategy = GenerationType.TABLE)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Categoria grupo;

	@Override
	public String getAuthority() {
		return this.grupo.getDescricao();
	}

	@Override
	public String toString() {
		return grupo.getDescricao();
	}
}
