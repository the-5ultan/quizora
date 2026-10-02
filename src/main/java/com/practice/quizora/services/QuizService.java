package com.practice.quizora.services;

import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import com.practice.quizora.models.Quiz;
import com.practice.quizora.repositories.QuestionRepository;
import com.practice.quizora.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> create(Category category, int NumQ, String title){
        try {
            List<Question> questions = questionRepository.createQuizRandomly(category,NumQ);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizRepository.save(quiz);
            return new  ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new  ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Quiz> getQuizById(int id) {
        try {
            return new ResponseEntity<>(quizRepository.getReferenceById(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
