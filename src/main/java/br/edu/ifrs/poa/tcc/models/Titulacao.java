package br.edu.ifrs.poa.tcc.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "titulos")
public class Titulacao extends BaseEntity {
    private static final long serialVersionUID = 1L;

    protected String nomeclatura;
    @Enumerated(EnumType.STRING)
    protected TipoTituloEnum tipo;
    protected String descricao;

    public Titulacao() {

    }

    public Titulacao(String nomeclatura, TipoTituloEnum tipo, String descricao) {
        super();
        this.nomeclatura = nomeclatura;
        this.tipo = tipo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "Titulacao{" +
                "nomeclatura='" + nomeclatura + '\'' +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                ", id=" + id +
                '}';
    }
}
