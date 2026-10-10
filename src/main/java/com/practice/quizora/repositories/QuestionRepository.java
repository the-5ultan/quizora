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

    //We can convert the Category to String but this can
    List<Question> findByCategory(Category category);
    void deleteQuestionByQuestionTitle(String questionTitle);
    @Query(//For the PostgreSQL the RAND() should be changed to RANDOM()
            value = "SELECT * FROM questions " +
                    "WHERE category = :category " +
                    "ORDER BY RAND() " +
                    "LIMIT :numQ",
            nativeQuery = true
    )
    List<Question> createQuizRandomly(
            @Param("category") String category,
            @Param("numQ") int numQ
    );
}