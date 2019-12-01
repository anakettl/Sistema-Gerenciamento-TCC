package br.edu.ifrs.poa.tcc.security.user;

import javax.validation.constraints.NotBlank;

public class CadastroDto {
    @NotBlank(message = "Username em branco")
    private String username;
    @NotBlank(message = "Senha invalida")
    private String password;
    @NotBlank(message = "Nome em branco")
    private String nome;
    @NotBlank(message = "Email em branco")
    private String email;
    @NotBlank(message = "Telefone em branco")
    private String telefone;
    @NotBlank(message = "Matricula em branco")
    private String matricula;
    @NotBlank(message = "CPF em branco")
    private String cpf;
    private Categoria categoria;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
