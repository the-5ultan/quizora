package com.practice.quizora.services;


import com.practice.quizora.models.Question;
import com.practice.quizora.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }
}
