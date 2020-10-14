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
@AllArgsConstructor
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

}
