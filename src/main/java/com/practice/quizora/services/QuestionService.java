package com.practice.quizora.services;


import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import com.practice.quizora.repositories.QuestionRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() throws NullPointerException{
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(Category category) throws NullPointerException{
        return questionRepository.findByCategory(category);
    }

    public String saveQuestion(Question question) {
        questionRepository.save(question);
        return "success";
    }

    public String deleteQuestionById(int id) {
        questionRepository.deleteById(id);
        return "successfully deleted"+id;
    }

    public String deleteQuestionByQuestionTitle(String questionTitle) {
        questionRepository.deleteQuestionByQuestionTitle(questionTitle);
        return  "successfully deleted "+questionTitle;
    }
}
