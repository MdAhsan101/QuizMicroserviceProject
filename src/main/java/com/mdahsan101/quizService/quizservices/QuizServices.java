package com.mdahsan101.quizService.quizservices;

import com.mdahsan101.quizService.interfaces.QuestionsServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServices {
    @Autowired
    QuestionsServiceClient questionsServiceClient;

    public ResponseEntity<List<Integer>> getQuestionIdsFromQuestionService(String category, int noq){
        return questionsServiceClient.getQuestionIds(category,noq);
    }
}
