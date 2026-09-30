package com.practice.quizora.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="question")
public class QuestionController {
    @GetMapping(path="getQuestions")
    public String question(){
        return "You've reached question controller";
    }
}
