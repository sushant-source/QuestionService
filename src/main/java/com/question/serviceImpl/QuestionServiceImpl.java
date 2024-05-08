package com.question.serviceImpl;

import com.question.entites.Question;
import com.question.repositories.QuestionRepo;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsByQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
