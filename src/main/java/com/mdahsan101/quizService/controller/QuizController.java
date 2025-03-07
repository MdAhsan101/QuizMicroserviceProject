package com.mdahsan101.quizService.controller;

import com.mdahsan101.quizService.models.Quiz;
import com.mdahsan101.quizService.quizservices.QuizServices;
import com.mdahsan101.quizService.repositories.QuizDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @Autowired
    QuizDbRepository quizDbRepository;

    @GetMapping(path = "/createquiz/{cat}/{noq}")
    public void createQuiz(@PathVariable("cat") String category, @PathVariable("noq") Integer noq){

        List<Integer> quesIds= quizServices.getQuestionIdsFromQuestionService(category,noq).getBody();

        LocalDateTime timeStamp= LocalDateTime.now();

        Quiz quiz= new Quiz();
        quiz.setQuizCategory(category);
        quiz.setNoq(noq);
        quiz.setCreatedDate(timeStamp);
        quiz.setQuesIdsList(quesIds);

        quizDbRepository.save(quiz);
        System.out.println(String.format("Quiz creation successfull with Quiz ID:: %d",quizDbRepository.findBycreatedDate(timeStamp).getQuizId()));
    }
}
