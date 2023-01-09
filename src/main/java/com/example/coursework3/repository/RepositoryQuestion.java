package com.example.coursework3.repository;

import com.example.coursework3.model.Question;

import java.util.Set;


public interface RepositoryQuestion {

    public Question add(Question question);

    public  Question remove(String question, String answer);

    public Set<Question> getQuestions();

    public  Question getRandomQuestion();
}
