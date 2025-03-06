package com.mdahsan101.quizService.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "quiz_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer quizId;

    @NotEmpty
    @Column(name = "category")
    public String quizCategory;

    @NotNull
    @Column(name="no_of_questions")
    public Integer noq;

    @NotNull
    @Column(columnDefinition = "TIMESTAMP")
    public LocalDateTime createdDate;

    @ElementCollection
    @CollectionTable(
            name="ques_ids_table",
            joinColumns = @JoinColumn(name="quiz_id")
    )
    @Column(name="ques_ids")
    public List<Integer> quesIdsList;
}
