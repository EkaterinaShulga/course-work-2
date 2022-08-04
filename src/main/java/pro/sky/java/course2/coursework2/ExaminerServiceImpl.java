package pro.sky.java.course2.coursework2;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.exception.ExaminerWrongNumberQuestionException;
import pro.sky.java.course2.coursework2.service.ExaminerService;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new ExaminerWrongNumberQuestionException();
        }
        Set<Question> result = new HashSet<>(amount);
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }
}




