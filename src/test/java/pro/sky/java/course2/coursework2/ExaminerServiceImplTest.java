package pro.sky.java.course2.coursework2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.exception.ExaminerWrongNumberQuestionException;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestionsPositiveTest() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("what is byte", "primitive type"));
        questions.add(new Question("what is double", "primitive type"));
        questions.add(new Question("what is String", "reference type"));
        questions.add(new Question("what is char", "primitive type"));
        questions.add(new Question("what is long", "primitive type"));

        when(javaQuestionService.getAll()).thenReturn(questions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(1), questions.get(2));
        Assertions.assertThat(examinerService.getQuestions(2)).containsExactlyInAnyOrder(questions.get(0), questions.get(1));

        when(javaQuestionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(1), questions.get(2), questions.get(3), questions.get(4));
        Assertions.assertThat(examinerService.getQuestions(3)).containsExactlyInAnyOrder(questions.get(0), questions.get(1), questions.get(2));

    }

    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(ExaminerWrongNumberQuestionException.class).isThrownBy(() -> examinerService.getQuestions(-1));
        Assertions.assertThatExceptionOfType(ExaminerWrongNumberQuestionException.class).isThrownBy(() -> examinerService.getQuestions(1));

    }
}
