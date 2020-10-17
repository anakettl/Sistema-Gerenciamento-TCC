package br.edu.ifrs.poa.sgtcc.dto;

public class AlunoDto {


    private String nome;

    private String email;

    private Long telefone;

    private Long matricula;

    private String cpf;

    public AlunoDto(String nome, String email, Long telefone, Long matricula, String cpf) {
        super();
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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
