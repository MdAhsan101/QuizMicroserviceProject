package com.mdahsan101.quizService.quizservices;

import com.mdahsan101.quizService.interfaces.QuestionsServiceClient;
import com.mdahsan101.quizService.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public List<Question> getAllQuestionsfromQuestionService(List<Integer> ques_ids){
        ResponseEntity<List<Question>> ques_service_reponse= questionsServiceClient.getQuestionsUsingIds(ques_ids);
        if(ques_service_reponse.getStatusCode()== HttpStatus.NOT_FOUND)
            return null;
        return ques_service_reponse.getBody();
    }
}
