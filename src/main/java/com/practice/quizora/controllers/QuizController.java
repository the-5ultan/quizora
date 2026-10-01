package com.practice.quizora.controllers;

import com.practice.quizora.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping(path="quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    
}
