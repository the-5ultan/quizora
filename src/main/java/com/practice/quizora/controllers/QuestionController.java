package com.practice.quizora.controllers;

import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import com.practice.quizora.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="category/{category}")
    public List<Question> category(@PathVariable("category") Category category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping(path="add")
    public String addQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @DeleteMapping(path="del/{id}")
    public String deleteQuestion(@PathVariable("id") int id){
        return questionService.deleteQuestionById(id);
    }

    @DeleteMapping(path="del")
    public String deleteQuestionByQuestionTitle(@RequestParam("questionTitle") String questionTitle){
        return questionService.deleteQuestionByQuestionTitle(questionTitle);
    }
}
