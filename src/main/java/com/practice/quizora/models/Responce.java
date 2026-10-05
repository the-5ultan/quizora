package com.practice.quizora.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;

@Data
@RequiredArgsConstructor
public class Responce {
    private Integer id;
    private String answer;
}
