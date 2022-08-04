package pro.sky.java.course2.coursework2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.coursework2.exception.QuestionAlreadyOnListException;
import pro.sky.java.course2.coursework2.exception.QuestionNotFoundException;


import java.util.*;


public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    public void addQuestionsPositiveTest() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        Question question1 = new Question("что такое int", "примитивный тип данных");
        Question question2 = new Question("что такое byte", "примитивный тип данных");
        Question result = javaQuestionService.add(question1);
        Question result2 = javaQuestionService.add(question2);
        Question result3 = javaQuestionService.add("что такое long", "примитивный тип данных");
        Assertions.assertThat(result).isEqualTo(question1);
        Assertions.assertThat(result2).isEqualTo(question2);
        Assertions.assertThat(result3).isEqualTo(result3);


    }

    @Test
    public void addQuestionsNegativeTest() {
        Question question = new Question("что такое int", "примитивный тип данных");
        Question question2 = new Question("что такое byte", "примитивный тип данных");
        javaQuestionService.add(question);
        javaQuestionService.add(question2);
        org.junit.jupiter.api.Assertions.assertThrows(QuestionAlreadyOnListException.class, () -> javaQuestionService.add(question));

    }

    @Test
    public void removeQuestionsPositiveTest() {
        Question question1 = new Question("что такое int", "примитивный тип данных");
        Question question2 = new Question("что такое byte", "примитивный тип данных");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Question result = javaQuestionService.remove(question1);
        Assertions.assertThat(result).isEqualTo(question1);


    }

    @Test
    public void removeQuestionsNegativeTest() {
        javaQuestionService.add(new Question("что такое int", "примитивный тип данных"));
        javaQuestionService.add(new Question("что такое byte", "примитивный тип данных"));
        Question question3 = new Question("что такое long", "примитивный тип данных");
        org.junit.jupiter.api.Assertions.assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(question3));

    }

    @Test
    public void getAllQuestionsPositiveTest() {
        Question question1 = new Question("что такое int", "примитивный тип данных");
        Question question2 = new Question("что такое byte", "примитивный тип данных");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Collection<Question> result = javaQuestionService.getAll();
        Assertions.assertThat(result).isEqualTo(result);

    }

    @Test
    public void getRandomQuestionTest() {
        javaQuestionService.add(new Question("what is byte", "primitive type"));
        javaQuestionService.add(new Question("what is double", "primitive type"));
        javaQuestionService.add(new Question("what is String", "reference type"));
        javaQuestionService.add(new Question("what is char", "primitive type"));
        javaQuestionService.add(new Question("what is long", "primitive type"));
        Collection<Question> result = javaQuestionService.getAll();
        Question question = javaQuestionService.getRandomQuestion();
        Assertions.assertThat(question).isEqualTo(question);


    }


}


