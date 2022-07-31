package pro.sky.java.course2.coursework2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.java.course2.coursework2.Question;
import pro.sky.java.course2.coursework2.service.QuestionService;

import java.util.Collection;

@Controller
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {

        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam ("question") String question,
                                @RequestParam ("answer") String answer){
        return questionService.add(question, answer);
    }
    @GetMapping("/find")
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam ("question") String question,
                                @RequestParam ("answer") String answer){
        return questionService.remove(new Question(question, answer));
    }
}
