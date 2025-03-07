package com.mdahsan101.quizService.repositories;

import com.mdahsan101.quizService.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface QuizDbRepository extends JpaRepository<Quiz,Integer> {
    public Quiz findBycreatedDate(LocalDateTime localDateTime);
}
