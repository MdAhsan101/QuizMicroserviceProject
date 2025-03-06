package com.mdahsan101.quizService.interfaces;

import com.mdahsan101.quizService.models.Question;
import com.mdahsan101.quizService.models.QuestionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient(name = "QUESTIONSSERVICE")
@RequestMapping(value = "/questions")
public interface QuestionsServiceClient {

    @GetMapping(value = "/getQuestionIds/{cat}/{noq}")
    public ResponseEntity<List<Integer>> getQuestionIds(@PathVariable("cat") String category, @PathVariable("noq") Integer num_of_ques);

    @PostMapping(value = "/getQuestionsWithIds")
    public ResponseEntity<List<Question>> getQuestionsUsingIds(@RequestBody List<Integer> ques_ids);
}
