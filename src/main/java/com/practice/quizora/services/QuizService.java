package com.practice.quizora.services;

import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import com.practice.quizora.repositories.QuestionRepository;
import com.practice.quizora.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class QuizService {
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> create(Category category, int NumQ, String title){
        try {
            questionRepository.createQuizRandomly(category,NumQ, title);
            return new  ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new  ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
