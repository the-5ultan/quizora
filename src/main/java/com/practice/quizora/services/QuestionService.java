package com.practice.quizora.services;


import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import com.practice.quizora.repositories.QuestionRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() throws NullPointerException{
        try {
            return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK );
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(Category category) throws NullPointerException{
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> saveQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("Successfully Created",HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to create",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> deleteQuestionById(int id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>("successfully deleted"+id,HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to Delete",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> deleteQuestionByQuestionTitle(String questionTitle) {
        try {
            questionRepository.deleteQuestionByQuestionTitle(questionTitle);
            return  new ResponseEntity<>("successfully deleted "+questionTitle,HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to Delete",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
