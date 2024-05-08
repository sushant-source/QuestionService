package com.question.controller;

import com.question.entites.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //  CREATE

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    //  GET_ALL

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    //  GET_BY_ID

    @GetMapping("/{questionId}")
    public Question getAll(@PathVariable Long questionId){
        return questionService.getOne(questionId);
    }

    //  GET_QUESTIONS_BY_QUIZ_ID

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuiz(@PathVariable Long quizId){
        return questionService.getQuestionsByQuiz(quizId);
    }
}
