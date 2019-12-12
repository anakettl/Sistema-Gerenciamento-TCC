package br.edu.ifrs.poa.tcc.models;

public enum TipoTituloEnum {
    GRADUACAO("Graduacao"), ESPECIALIZACAO("Especializacao"), MESTRADO("Mestrado"), DOUTORADO("Doutorado");

    private String campo;

    TipoTituloEnum(String campo) {
        this.campo = campo;
    }

    public String getCampo() {
        return this.campo;
    }
}
