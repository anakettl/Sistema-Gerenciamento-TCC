package br.edu.ifrs.poa.sgtcc.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ALUNOS")
@SequenceGenerator(name = "SEQUENCE_ALUNOS", allocationSize = 1)
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(generator = "SEQUENCE_ALUNOS", strategy = GenerationType.TABLE)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private List<Proposta> propostas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Avaliacao> avaliacoes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Banca> bancas;

    public Aluno(@NotBlank(message = "Nome obrigatório") String nome,
                 @NotBlank(message = "Email obrigatório") String email,
                 @NotBlank(message = "Telefone obrigatório") String telefone,
                 @NotBlank(message = "Matrícula obrigatória") String matricula,
                 @NotBlank(message = "CPF obrigatório") String cpf,
                 Integer id,
                 List<Proposta> propostas,
                 List<Avaliacao> avaliacoes,
                 List<Banca> bancas) {
        super(nome, email, telefone, matricula, cpf);
        this.id = id;
        this.propostas = propostas;
        this.avaliacoes = avaliacoes;
        this.bancas = bancas;
    }
}
