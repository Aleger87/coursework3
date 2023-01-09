package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.JavaQuestionService;
import com.example.coursework3.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/exam/java/")
public class JavaQuestionController {

    QuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Set<Question> questions() {
        return (Set<Question>) questionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam("q") String question,
                        @RequestParam("a") String answer) {
        return questionService.add(question, answer);
    }


    @GetMapping("/remove")
    public Question remove(@RequestParam("q") String question,
                       @RequestParam("a") String answer) {
     return questionService.remove(question, answer);
    }

    @GetMapping("/random")
    public Question random() {
        return questionService.getRandomQuestion();
    }
}
