import br.edu.ifrs.poa.sgtcc.models.Professor;
import br.edu.ifrs.poa.sgtcc.models.Titulacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.edu.ifrs.poa.sgtcc.models.TipoTituloEnum.MESTRADO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitulacaoTest {
    private Titulacao titulo;

    @BeforeEach
    void Setup () {
        titulo = new Titulacao(1, "Mestrado", MESTRADO, "Titulo de mestre");
    }

    @Test
    void getterAndSetterNomenclatura(){
        titulo.setNomeclatura("");
        assertEquals("", titulo.getNomeclatura());
    }

    @Test
    void getterAndSetterDescricao(){
        titulo.setDescricao("");
        assertEquals("", titulo.getDescricao());
    }
}
