package com.pooja.calculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculationRequest {
    @NotNull
    private Long firstNumber;
    @NotNull
    private Long secondNumber;
}
