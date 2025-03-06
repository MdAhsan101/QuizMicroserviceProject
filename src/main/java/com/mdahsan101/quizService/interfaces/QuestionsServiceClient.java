package com.mdahsan101.quizService.interfaces;

import com.mdahsan101.quizService.models.Question;
import com.mdahsan101.quizService.models.QuestionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient(name = "QUESTIONSSERVICE")
public interface QuestionsServiceClient {

    @GetMapping(value = "/questions/getQuestionIds/{cat}/{noq}")
    public ResponseEntity<List<Integer>> getQuestionIds(@PathVariable("cat") String category, @PathVariable("noq") Integer num_of_ques);

    @PostMapping(value = "/questions/getQuestionsWithIds")
    public ResponseEntity<List<Question>> getQuestionsUsingIds(@RequestBody List<Integer> ques_ids);
}
