package br.edu.ifrs.poa.tcc.models;

import javax.persistence.*;

@Entity
@Table(name = "alunos")
@SequenceGenerator(name = "SEQUENCE_ALUNO", initialValue = 1, allocationSize = 1)
public class Aluno extends Pessoa {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SEQUENCE_ALUNO", strategy = GenerationType.TABLE)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Proposta proposta;
    
    public Aluno() {

    }

    public Aluno(String nome, String email, String telefone, String matricula, String cpf) {
        super(nome, email, telefone, matricula, cpf);
    }

    public Integer getId() {
        return id;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }
    
    @Override
    public String toString() {
        return "Aluno{" +
                "proposta=" + proposta +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
