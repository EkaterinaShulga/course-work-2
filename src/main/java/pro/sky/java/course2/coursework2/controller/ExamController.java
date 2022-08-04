package pro.sky.java.course2.coursework2.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework2.Question;
import pro.sky.java.course2.coursework2.service.ExaminerService;
import java.util.Collection;


@RestController
public class ExamController {
    private  final ExaminerService examinerService;

    ExamController (ExaminerService examinerService){
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
public Collection<Question> getQuestions(@PathVariable int amount){
return examinerService.getQuestions(amount);
    }
}
