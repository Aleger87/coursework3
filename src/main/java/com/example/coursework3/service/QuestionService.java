package com.example.coursework3.service;

import com.example.coursework3.model.Question;

import java.util.Collection;

public interface QuestionService {

  public Question add(String question, String answer);

  public Question remove(String question, String answer);

  public Collection<Question> getAll();

  public Question getRandomQuestion();




}
