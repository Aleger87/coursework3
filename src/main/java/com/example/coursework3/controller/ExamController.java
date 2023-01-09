package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
@RequestMapping("/exam/java/")
public class ExamController {

    ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/count")
    public Collection<Question> getQuestions(@RequestParam("c") int amount){
        return examinerService.getQuestions(amount);
    }

}
