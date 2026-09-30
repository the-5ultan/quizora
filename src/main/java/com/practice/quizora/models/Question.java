package com.practice.quizora.models;

import com.practice.quizora.enums.Category;
import com.practice.quizora.enums.DifficultyLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Category category;
    private DifficultyLevel difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTittle;
    private String rightOption;


}
