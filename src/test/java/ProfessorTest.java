
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
    void registerProfessorWithoutName(){
        professor.setNome("");
        assertEquals("", professor.getNome());
    }

    @Test
    void registerProfessorWithoutEmail(){
        professor.setEmail("");
        assertEquals("", professor.getEmail());
    }

    @Test
    void registerProfessorWithoutCpf(){
        professor.setCpf("");
        assertEquals("", professor.getCpf());
    }

    @Test
    void registerProfessorWithoutTelefone(){
        professor.setTelefone("");
        assertEquals("", professor.getTelefone());
    }

    @Test
    void registerProfessorWithoutMatricula(){
        professor.setMatricula("");
        assertEquals("", professor.getMatricula());
    }


}
