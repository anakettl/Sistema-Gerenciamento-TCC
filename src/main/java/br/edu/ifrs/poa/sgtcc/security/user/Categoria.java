package br.edu.ifrs.poa.sgtcc.security.user;

public enum Categoria {
    PROFESSOR(Valores.PROFESSOR), ALUNO(Valores.ALUNO), ADMIN(Valores.ADMIN);

    private String descricao;

    Categoria(String descricao) {
    	this.descricao = descricao;
    }
    
    public String getDescricao() {
    	return this.descricao;
    }

    public static class Valores {
        static final String PROFESSOR = "PROFESSOR";
        static final String ALUNO = "ALUNO";
        static final String ADMIN = "ADMIN";
    }

}
