package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import com.example.coursework3.repository.RepositoryQuestionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private RepositoryQuestionImpl repositoryQuestion;

    @InjectMocks
    private JavaQuestionService javaQuestionService = new JavaQuestionService(repositoryQuestion);

    private Set<Question> questions = new HashSet<>();
    private Question question = new Question("test1", "test1");


    @BeforeEach
    void setUp() {
        questions.add(question);
    }

    @Test
    void add() {
        Set<Question> actualQuestions = new HashSet<>();
        actualQuestions.add(new Question("test1", "test1"));
        when(repositoryQuestion.add(question)).thenReturn(question);
        Assertions.assertEquals(repositoryQuestion.add(question), question);
    }

    @Test
    void remove() {
        when(repositoryQuestion.remove(anyString(), anyString())).thenReturn(question);
        Assertions.assertEquals(repositoryQuestion.remove(anyString(),anyString()), question);
    }

    @Test
    void getAll() {
        when(repositoryQuestion.getQuestions()).thenReturn(questions);
        Assertions.assertEquals(repositoryQuestion.getQuestions(), questions);

    }

    @Test
    void getRandomQuestion() {
        when(repositoryQuestion.getRandomQuestion()).thenReturn(question);
        Assertions.assertEquals(repositoryQuestion.getRandomQuestion(), question);
    }

}