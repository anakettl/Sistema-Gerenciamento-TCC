package br.edu.ifrs.poa.tcc.dto;

import br.edu.ifrs.poa.tcc.models.Categoria;

public class AutDto {
    private String username;
    private String password;
    private Categoria tipo;

    public AutDto(String username, String password, Categoria tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

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

    public Categoria getTipo() {
        return tipo;
    }

    public void setTipo(Categoria tipo) {
        this.tipo = tipo;
    }
}
