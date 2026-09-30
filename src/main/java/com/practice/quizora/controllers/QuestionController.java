package com.practice.quizora.controllers;

import com.practice.quizora.models.Question;
import com.practice.quizora.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (path="question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping(path="getQuestions")
    public List<Question> question(){
        return questionService.getAllQuestions();
    }
}
