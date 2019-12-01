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
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
