package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"autor", "orientador"})
@Entity
@Table(name = "PROPOSTAS")
@SequenceGenerator(name = "SEQUENCE_PROPOSTAS", allocationSize = 1)
public class Proposta {

    @Id
    @GeneratedValue(generator = "SEQUENCE_PROPOSTAS", strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "FK_AUTOR_UID")
    private Aluno autor;

    @ManyToOne
    @JoinColumn(name = "FK_ORIENTADOR_UID")
    private Professor orientador;

    @OneToOne(mappedBy = "proposta")
    private Banca banca;
}
