package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

// é importante inserir anotações de validações para que o spring não aceite qualquer string ou qualuqe BigDecimal
public record StudentsRecord(
        @NotBlank String name,
        @NotNull Integer age,
        @NotNull Integer firstGrade,
        @NotNull Integer secondGrade,
        @NotNull String teacherName,
        @NotNull Integer roomNumber
) implements Serializable {

}
