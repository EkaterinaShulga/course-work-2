package pro.sky.java.course2.coursework2;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.service.QuestionService;
import pro.sky.java.course2.coursework2.exception.QuestionAlreadyOnListException;
import pro.sky.java.course2.coursework2.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionsSet;
    private final Random random;

    public JavaQuestionService() {
        this.questionsSet = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));

    }

    @Override
    public Question add(Question question) {
        if (questionsSet.contains(question)) {
            throw new QuestionAlreadyOnListException();
        }
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questionsSet.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questionsSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsSet);

    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questionsSet).get(random.nextInt(questionsSet.size()));

    }

}

