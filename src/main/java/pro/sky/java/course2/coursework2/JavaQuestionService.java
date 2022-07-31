package pro.sky.java.course2.coursework2;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.service.QuestionService;
import pro.sky.java.course2.coursework2.exception.QuestionAlreadyOnListException;
import pro.sky.java.course2.coursework2.exception.QuestionNotFoundException;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionsSet;

    public JavaQuestionService() {
        this.questionsSet = new HashSet<>();
   }

   @Override
    public Question add(String question, String answer){
       return  add(new Question(question, answer));

   }

   @Override
  public  Question add(Question question) {
       if (questionsSet.contains(question)) {
           throw new QuestionAlreadyOnListException();
       }
        questionsSet.add(question);
       System.out.println("добавлен вопрос "+ question);
        return  question;
    }

    @Override
    public Question remove(Question question) {
        if(!questionsSet.contains(question)){
            throw new QuestionNotFoundException();
        }
        questionsSet.remove(question);
        System.out.println("удален вопрос "+ question);
        return question;
    }
    @Override
    public Collection<Question> getAll() {
        System.out.println("Список вопросов " + questionsSet);
        return Collections.unmodifiableCollection(questionsSet);

    }
    @Override
    public Question getRandomQuestion() {
        Set<Question> questionSet = new HashSet<>();
        Question[] questionArray = new Question[questionSet.size()];
        int i = 0;
        for (Question s : questionSet) {
            questionArray[i++] = s;
        }
        System.out.println(Arrays.toString(questionArray) + " это массив");
        Random random = new Random();
        int questionResult = random.nextInt(questionSet.size()) + 1;
        System.out.println(questionResult);
        Question questionForStudent = null;
        for (int j = 0; j < questionArray.length; j++) {
            if (questionResult == j) {
                questionForStudent = questionArray[j];

            }
        }return questionForStudent;
    }

    }

