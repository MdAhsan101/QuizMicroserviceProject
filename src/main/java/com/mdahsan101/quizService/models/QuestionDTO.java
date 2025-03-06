package com.mdahsan101.quizService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    Integer qId;
    List<Option> options;
    String qDescription;
    String qCategory;
    Integer qMarks;
}
