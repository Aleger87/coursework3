package com.example.coursework3.service;

import com.example.coursework3.exeption.BadRequestException;
import com.example.coursework3.model.Question;
import com.example.coursework3.repository.RepositoryQuestionImpl;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService{

      private RepositoryQuestionImpl repositoryQuestion;

      public JavaQuestionService(RepositoryQuestionImpl repositoryQuestion) {
          this.repositoryQuestion = repositoryQuestion;
      }
//    Set<Question> repositoryQuestion = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        checkData(question, answer);
        isBlank(question, answer);
        return repositoryQuestion.add(new Question(question,answer));

    }


    @Override
    public Question remove(String question, String answer) {
        checkData(question, answer);
        isBlank(question, answer);
        return repositoryQuestion.remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return repositoryQuestion.getQuestions();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> newQuestions =new ArrayList<>(repositoryQuestion.getQuestions());
        return newQuestions.get(randomIndex(newQuestions.size()));
    }

    private int randomIndex(int max) {
        Random randomIndex = new Random();
        int x = randomIndex.nextInt(max);
        return x;
    }

    private void checkData (Object... o) {
        for (Object object:o) {
            if (object == null) {
                throw new BadRequestException("значение null");
            }
        }
    }

    private void isBlank(String... strings) {
        for (String s:strings) {
            if (s.isBlank()) {
                throw new BadRequestException("пустое значение");
            }
        }
    }
}
