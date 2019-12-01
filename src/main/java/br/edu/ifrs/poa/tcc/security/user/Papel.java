package br.edu.ifrs.poa.tcc.security.user;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "PAPEL")
public class Papel implements  GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Categoria grupo;

	@Override
	public String getAuthority() {
		return this.grupo.getDescricao();
	}

}
