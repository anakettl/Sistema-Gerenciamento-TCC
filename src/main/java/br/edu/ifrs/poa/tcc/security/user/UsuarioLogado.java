package br.edu.ifrs.poa.tcc.security.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private List<Papel> papeis = new ArrayList<>();

	public UsuarioLogado() {
	}

	public UsuarioLogado(String username, String password, List<Papel> papeis) {
		this.username = username;
		this.password = password;
		this.papeis = papeis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.papeis;
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

	public boolean isRole(Categoria role) {
		if (this.papeis.contains(role)){
			return true;
		}
		return false;
	}
}
