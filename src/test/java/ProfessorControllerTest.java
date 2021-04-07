//import br.edu.ifrs.poa.sgtcc.controllers.ProfessorController;
//import br.edu.ifrs.poa.sgtcc.models.Professor;
//import br.edu.ifrs.poa.sgtcc.repositories.ProfessorRepository;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.web.servlet.ModelAndView;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ProfessorControllerTest {
//    @InjectMocks
//    private ProfessorController professorController;
//
//    @Mock
//    private ProfessorRepository professorRepository;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetProfessorById() {
//        ModelAndView model = new ModelAndView("redirect:/professores");
//        Professor p = new Professor();
//        p.setId(1l);
//        when(professorRepository.findOne(1l)).thenReturn(p);
//
//        Professor professor = professorController.ver(1L);
//
//        verify(professorRepository).findOne(1l);
//
//        assertEquals(1l, professor.getId().longValue());
//    }
//}
