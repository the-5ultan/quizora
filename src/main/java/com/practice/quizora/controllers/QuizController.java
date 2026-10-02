package com.practice.quizora.controllers;

import com.practice.quizora.enums.Category;
import com.practice.quizora.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@RequestMapping(path="quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping(path="create")
    public ResponseEntity<String> createQuiz(@RequestParam Category category, @RequestParam int NumQ, @RequestParam String title){
        return quizService.create(category, NumQ, title);
    }
}
