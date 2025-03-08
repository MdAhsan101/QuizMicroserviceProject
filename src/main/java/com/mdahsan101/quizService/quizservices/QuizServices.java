package com.mdahsan101.quizService.quizservices;

import com.mdahsan101.quizService.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RefreshScope
public class QuizServices {

    @Autowired
    RestTemplate restTemplate;

    @Value("${questionsservice.getids.uri}")
    String getQuestionIdsURI;

    @Value("${questionsservice.getquestions.uri}")
    String getQuestionsURI;

    public ResponseEntity<List<Integer>> getQuestionIdsFromQuestionService(String category, int noq){
        String uri= new String(getQuestionIdsURI+category+"/"+noq);
        ResponseEntity<List<Integer>> response= restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response;
    }

    public List<Question> getAllQuestionsfromQuestionService(List<Integer> ques_ids){
        // HttpHeaders headers = new HttpHeaders();
        // headers.set("Authorization", "Bearer token");
        // null underneath is header
        HttpEntity<List<Integer>> httpEntity= new HttpEntity<>(ques_ids,null);
        ResponseEntity<List<Question>> ques_service_reponse= restTemplate.exchange(getQuestionsURI,HttpMethod.POST,httpEntity, new ParameterizedTypeReference<>() {
        });
        if(ques_service_reponse.getStatusCode()== HttpStatus.NOT_FOUND)
            return null;
        return ques_service_reponse.getBody();
    }
}
