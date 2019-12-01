package br.edu.ifrs.poa.tcc.security.user;

public enum Categoria {
    PROFESSOR("Professor"), ALUNO("Aluno"), ADMIN("Administrador");

    private String descricao;

    Categoria(String descricao) {
    	this.descricao = descricao;
    }
    
    public String getDescricao() {
    	return this.descricao;
    }
}
