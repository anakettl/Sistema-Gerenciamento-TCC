package br.edu.ifrs.poa.tcc.models;

public enum Categoria {
    PROFESSOR("Professor"), ALUNO("Aluno"), ADMIN("Administrador");

    private String t;

    Categoria(String t) {
    	this.t = t;
    }
    
    public String getT() {
    	return this.t;
    }
}
