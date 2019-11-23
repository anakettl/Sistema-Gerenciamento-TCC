package br.edu.ifrs.poa.tcc.security;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifrs.poa.tcc.models.Roles;
import org.springframework.security.core.GrantedAuthority;


@Entity
public class Papel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Roles nome;

    @Override
    public String getAuthority() {
        return nome.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getNome() {
        return nome;
    }

    public void setNome(Roles nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Papel [id=" + id + ", nome=" + nome + "]";
    }
}
