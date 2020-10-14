package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.*;

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
@Table(name = "AVALIACOES")
@SequenceGenerator(name = "SEQUENCE_AVALIACOES", allocationSize = 1)
public class Avaliacao {

    @Id
    @GeneratedValue(generator = "SEQUENCE_AVALIACOES", strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "FK_ALUNO_UID")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "FK_PROFESSOR_UID")
    private Professor professor;
    
    @Column(nullable = false)
    private String linguagem;
    
    @Column(nullable = false)
    private String apresentacao;
    
    @Column(nullable = false)
    private String estruturaTexto;
    
    @Column(nullable = false)
    private String conteudoTexto;
    
    @Column(nullable = false)
    private String relevancia;
    
    @Column(nullable = false)
    private boolean aprovado;
    
    @Column
    private String observacao;
}
