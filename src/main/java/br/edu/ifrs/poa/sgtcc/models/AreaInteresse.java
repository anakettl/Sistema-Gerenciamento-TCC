package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "AREAS_INTERESSE")
@SequenceGenerator(name = "SEQUENCE_AREAS_INTERESSE", allocationSize = 1)
public class AreaInteresse {

    @Id
    @GeneratedValue(generator = "SEQUENCE_AREAS_INTERESSE", strategy = GenerationType.TABLE)
    private Integer id;

    @NotBlank(message = "Descrição é obrigatória")
    @Column(length = 50, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "FK_PROFESSOR_UID")
    private Professor professor;

}
