package br.edu.ifrs.poa.tcc.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@MappedSuperclass
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Nome obrigatório")
    @Column(length = 55, nullable = false)
    protected String nome;

    @NotBlank(message = "Email obrigatório")
    @Email(message = "Email inválido")
    @Column(length = 80, nullable = false)
    protected String email;

    @NotBlank(message = "Telefone obrigatório")
    @Column(length = 30)
    protected String telefone;

    @NotBlank(message = "Matrícula obrigatória")
    @Column(length = 80, nullable = false)
    protected String matricula;

    @NotBlank(message = "CPF obrigatório")
    @Column(length = 80, nullable = false)
    protected String cpf;

    public Pessoa() {

    }

    public Pessoa(String nome, String email, String telefone, String matricula, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
