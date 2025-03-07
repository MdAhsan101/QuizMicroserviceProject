package com.mdahsan101.quizService.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Question {

    public Question(List<Option> options, String qDescription, @Nullable String qCategory, Integer qMarks, Integer answer) {
        this.options = options;
        this.qDescription = qDescription;
        this.qCategory = qCategory;
        this.qMarks = qMarks;
        this.answer = answer;
    }

    public Integer qId;

    @Size(min=2,max=2)
    @NotEmpty
    public List<Option> options;

    @NotEmpty
    public String qDescription;

    @Nullable
    public String qCategory;

    @Min(1)
    @Max(5)
    public Integer qMarks;

    @Min(1)
    @Max(2)
    public Integer answer;

    @Override
    public String toString() {
        return "Question{" +
                "qId=" + qId +
                ", options=" + options +
                ", qDescription='" + qDescription + '\'' +
                ", qCategory='" + qCategory + '\'' +
                ", qMarks=" + qMarks +
                ", answer=" + answer +
                '}';
    }
}
