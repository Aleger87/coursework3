package com.example.coursework3.service;

import com.example.coursework3.model.Question;

import java.util.Collection;


public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
    public boolean checkCountQuestions(int amount);
}
