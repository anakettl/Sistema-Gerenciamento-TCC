
import br.edu.ifrs.poa.sgtcc.models.Professor;
import br.edu.ifrs.poa.sgtcc.models.Titulacao;
import br.edu.ifrs.poa.sgtcc.service.ProfessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.edu.ifrs.poa.sgtcc.models.TipoTituloEnum.MESTRADO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfessorTest {

    private Titulacao titulo;
    private Professor professor;

    @BeforeEach
    void Setup () {
        titulo = new Titulacao(1, "Mestrado", MESTRADO, "Titulo de mestre");
        professor = new Professor("Maria Claudia", "claudiasilva@gmail.com", "51 98398283", "12345", "463848934", 1, titulo, null, null);
    }

    @Test
    void getterAndSetterNome(){
        professor.setNome("");
        assertEquals("", professor.getNome());
    }

    @Test
    void getterAndSetterEmail(){
        professor.setEmail("");
        assertEquals("", professor.getEmail());
    }

    @Test
    void getterAndSetterCpf(){
        professor.setCpf("");
        assertEquals("", professor.getCpf());
    }

    @Test
    void getterAndSetterTelefone(){
        professor.setTelefone("");
        assertEquals("", professor.getTelefone());
    }

    @Test
    void getterAndSetterMatricula(){
        professor.setMatricula("");
        assertEquals("", professor.getMatricula());
    }


}
