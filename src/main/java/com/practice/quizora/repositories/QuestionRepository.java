package com.practice.quizora.repositories;

import com.practice.quizora.enums.Category;
import com.practice.quizora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(Category category);
    void deleteQuestionByQuestionTitle(String questionTitle);
    @Query(value = "SELECT * FROM Questions q WHERE q.catagory=:category ORDER BY RAND() limit :`numQ`", nativeQuery = true)
    List<Question> createQuizRandomly(@Param("category") Category category,@Param("numQ") int numQ, String title);
}