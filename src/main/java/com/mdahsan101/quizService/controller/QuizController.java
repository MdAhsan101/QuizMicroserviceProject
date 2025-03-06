package com.mdahsan101.quizService.controller;

import com.mdahsan101.quizService.quizservices.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @GetMapping(path = "/createquiz/{cat}/{noq}")
    public void createQuiz(@PathVariable("cat") String category, @PathVariable("noq") Integer noq){
        System.out.println(quizServices.getQuestionIdsFromQuestionService(category,noq));
    }
}
