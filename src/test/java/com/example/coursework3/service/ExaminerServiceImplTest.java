package com.example.coursework3.service;
import com.example.coursework3.exeption.BadRequestException;
import com.example.coursework3.model.Question;

import com.example.coursework3.repository.RepositoryQuestion;
import com.example.coursework3.repository.RepositoryQuestionImpl;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



import java.util.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService questionService;

    @InjectMocks
    ExaminerService examinerService = new ExaminerServiceImpl(questionService);

    Set<String> actual = new HashSet<>();
    Set<Question> actualQuestions = new HashSet<>();



    @Test
    void getQuestionsTestWhenCorrectAmount() {
        Question actualQuestion = new Question("test1", "test1");
        actualQuestions.add(actualQuestion);
        actual.add(actualQuestion.getQuestion());
        when(questionService.getRandomQuestion()).thenReturn(actualQuestion);
        int amount = 1;
        Set<String> expected = new HashSet<>();
        while (expected.size() < amount) {
            expected.add(questionService.getRandomQuestion().getQuestion());
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getQuestionsTestWhenIncorrectAmount() {
        int amount = 1;
        Assertions.assertThrows(BadRequestException.class, () -> {
            examinerService.checkCountQuestions(amount);
        });

    }



}