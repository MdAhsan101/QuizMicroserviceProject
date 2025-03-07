package com.mdahsan101.quizService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Option {

    public Option(Integer optionNumber, String optionDescription) {
        this.optionNumber = optionNumber;
        this.optionDescription = optionDescription;
    }

    public Integer id;

    public Integer optionNumber;

    @NotEmpty
    public String optionDescription;

    public Question question;

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", optionNumber=" + optionNumber +
                ", optionDescription='" + optionDescription + '\'' +
                '}';
    }
}
