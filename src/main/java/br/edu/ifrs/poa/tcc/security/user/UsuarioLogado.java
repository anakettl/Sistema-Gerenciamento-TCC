package br.edu.ifrs.poa.tcc.security.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "SEQUENCE_USUARIO", initialValue = 1, allocationSize = 1)
public class UsuarioLogado implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "SEQUENCE_USUARIO", strategy = GenerationType.TABLE)
	private Integer id;
	
	@Column(nullable = false,unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Categoria papeis;

	public UsuarioLogado() {
	}

	public UsuarioLogado(String username, String password, Categoria papeis) {
		this.username = username;
		this.password = password;
		this.papeis = papeis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> permissoes = Stream
				.of(new SimpleGrantedAuthority(this.papeis.getDescricao()))
				.collect(toSet());
		return permissoes;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioLogado{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", papeis=" + papeis +
				'}';
	}
}
