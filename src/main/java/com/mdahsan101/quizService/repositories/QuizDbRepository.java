package com.mdahsan101.quizService.repositories;

import com.mdahsan101.quizService.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuizDbRepository extends JpaRepository<Quiz,Integer> {
    public Quiz findBycreatedDate(LocalDateTime localDateTime);

    @Query("select qz.quesIdsList from Quiz qz where quizId= :qid")
    public Optional<List<Integer>> findByquizId(@Param("qid") Integer quiz_id);
}
