package com.practice.quizora.repositories;

import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(Category category);
}
