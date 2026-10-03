package com.practice.quizora.services;

import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import com.practice.quizora.models.QuestionWrapper;
import com.practice.quizora.models.Quiz;
import com.practice.quizora.repositories.QuestionRepository;
import com.practice.quizora.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        try {
            Optional<Quiz> quiz = quizRepository.findById(id);
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            for (Question question : questions) {
                QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
            }
            return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
