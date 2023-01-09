package com.example.coursework3.service;

import com.example.coursework3.exeption.BadRequestException;
import com.example.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<String> questions = new HashSet<>();
        if (checkCountQuestions(amount)){
            while (questions.size() < amount) {
                questions.add(questionService.getRandomQuestion().getQuestion());
            }
        }
        return (Collection) questions;
    }

    @Override
    public boolean checkCountQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new BadRequestException("Количество вопросов меньше заявленного");
        }
        return true;
    }
}
