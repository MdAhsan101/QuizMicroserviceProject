package com.mdahsan101.quizService.controller;

import com.mdahsan101.quizService.models.Question;
import com.mdahsan101.quizService.models.QuestionDTO;
import com.mdahsan101.quizService.models.Quiz;
import com.mdahsan101.quizService.quizservices.QuizServices;
import com.mdahsan101.quizService.repositories.QuizDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    @Autowired
    QuizServices quizServices;

    @Autowired
    QuizDbRepository quizDbRepository;

    @GetMapping(path = "/createquiz/{cat}/{noq}")
    public ResponseEntity createQuiz(@PathVariable("cat") String category, @PathVariable("noq") Integer noq){

        List<Integer> quesIds= quizServices.getQuestionIdsFromQuestionService(category,noq).getBody();

        LocalDateTime timeStamp= LocalDateTime.now();

        Quiz quiz= new Quiz();
        quiz.setQuizCategory(category);
        quiz.setNoq(noq);
        quiz.setCreatedDate(timeStamp);
        quiz.setQuesIdsList(quesIds);

        quizDbRepository.save(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Quiz creation successfull with Quiz ID:: %d",quizDbRepository.findBycreatedDate(timeStamp).getQuizId()));
    }

    @GetMapping(path = "/getquizpaper/{id}")
    public ResponseEntity fetchQuizPaper(@PathVariable("id") Integer quiz_id){

        Optional<List<Integer>> ques_ids= quizDbRepository.findByquizId(quiz_id);
        if(ques_ids.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Quiz Id");
        }

        List<QuestionDTO> questionDtos= new ArrayList<>();
        List<Question> questions= quizServices.getAllQuestionsfromQuestionService(ques_ids.get());
        for(Question question:questions){
            questionDtos.add(convertQuestionToDTO(question));
        }
        return ResponseEntity.status(HttpStatus.OK).body(questionDtos);
    }

    private QuestionDTO convertQuestionToDTO(Question ques){
        return  new QuestionDTO(
                ques.getQId(),
                ques.getOptions(),
                ques.getQDescription(),
                ques.getQCategory(),
                ques.getQMarks()
        );
    }
}
