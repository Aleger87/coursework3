package com.example.coursework3.repository;

import com.example.coursework3.model.Question;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepositoryQuestionImpl  implements RepositoryQuestion{

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        for (Question q : questions) {
            if (q.getQuestion().equals(question) && q.getAnswer().equals(answer)) {
                questions.remove(q);
                return q;
            }
        }
        return null;
    }


    @Override
    public Set<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> newQuestions =new ArrayList<>(questions);
        return newQuestions.get(randomIndex(newQuestions.size()));
    }

    private int randomIndex(int max) {
        Random randomIndex = new Random();
        int x = randomIndex.nextInt(max);
        return x;
    }
}
