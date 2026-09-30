package com.practice.quizora.models;

import com.practice.quizora.enums.Catagory;
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
    private int id;
    private Catagory catagory;
    private DifficultyLevel difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questiontittle;
    private String rightoption;


}
