package com.practice.quizora.controllers;

import com.practice.quizora.enums.Category;
import com.practice.quizora.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping(path="create")
    public ResponseEntity<String> createQuiz(@RequestParam Category category, @RequestParam int numQ, @RequestParam String title){
        return quizService.create(category, numQ, title);
    }
}
