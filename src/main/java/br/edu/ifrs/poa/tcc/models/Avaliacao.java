package br.edu.ifrs.poa.tcc.models;

import javax.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String titulo;

    @OneToOne
    private Aluno autor;

    @ManyToOne
    private Professor orientador;
    
    @Column(nullable = false)
    private String linguagem;
    
    @Column(nullable = false)
    private String apresentacao;
    
    @Column(nullable = false)
    private String estrutura_texto;
    
    @Column(nullable = false)
    private String conteudo_texto;
    
    @Column(nullable = false)
    private String relevancia;
    
    @Column(nullable = false)
    private Boolean aprovado;
    
    @Column(nullable = false)
    private Boolean reprovado;
    
    @Column(nullable = false)
    private String observacao;
    

    public Avaliacao() {

    }

    public Avaliacao(String titulo, Aluno autor, Professor orientador, String linguagem, String apresentacao, String estrutura_texto, String conteudo_texto, String relevancia) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        this.orientador = orientador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno getAutor() {
        return autor;
    }

    public void setAutor(Aluno autor) {
        this.autor = autor;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }
    
}