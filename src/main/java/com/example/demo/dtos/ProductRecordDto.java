package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.math.BigDecimal;

// é importante inserir anotações de validações para que o spring não aceite qualquer string ou qualuqe BigDecimal
public record ProductRecordDto(@NotNull BigDecimal value, @NotBlank String name, @Range(min = 1L, max = 5L) Integer stars) implements Serializable {

}
