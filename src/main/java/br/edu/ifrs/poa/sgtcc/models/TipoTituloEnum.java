package br.edu.ifrs.poa.sgtcc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTituloEnum {
    GRADUACAO("Graduacao"), ESPECIALIZACAO("Especializacao"), MESTRADO("Mestrado"), DOUTORADO("Doutorado");

    private final String campo;
}
