package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString
@Entity
@Table(name = "TITULOS")
@SequenceGenerator(name = "SEQUENCE_TITULOS", allocationSize = 1)
public class Titulacao {

    @Id
    @GeneratedValue(generator = "SEQUENCE_TITULOS", strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String nomeclatura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTituloEnum tipo;

    @Column(nullable = false)
    private String descricao;

    public Titulacao(Integer id, String nomeclatura, TipoTituloEnum tipo, String descricao) {
        this.id = id;
        this.nomeclatura = nomeclatura;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeclatura() {
        return nomeclatura;
    }

    public void setNomeclatura(String nomeclatura) {
        this.nomeclatura = nomeclatura;
    }

    public TipoTituloEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTituloEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}