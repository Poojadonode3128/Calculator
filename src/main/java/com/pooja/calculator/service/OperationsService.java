package com.pooja.calculator.service;


import com.pooja.calculator.exception.InvalidOperationException;
import com.pooja.calculator.dto.CalculationRequest;
import com.pooja.calculator.model.Calculation;
import com.pooja.calculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
public class OperationsService {

    private final CalculationRepository calculationRepository;

    public OperationsService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Long add(CalculationRequest calculationRequest) {
        Calculation calculation = new Calculation();
        Long result = calculationRequest.getFirstNumber() + calculationRequest.getSecondNumber();
        calculation.setFirstNumber(calculationRequest.getFirstNumber());
        calculation.setSecondNumber(calculationRequest.getSecondNumber());
        calculation.setOperation("add");
        calculation.setResult(result);
        calculationRepository.save(calculation);
        return result;
    }

    public Long subtract(CalculationRequest calculationRequest) {
        return calculationRequest.getFirstNumber() - calculationRequest.getSecondNumber();
    }

    public Long multiply(CalculationRequest calculationRequest) {
        return calculationRequest.getFirstNumber() * calculationRequest.getSecondNumber();
    }

    public Long divide(CalculationRequest calculationRequest) {
        Long a = calculationRequest.getFirstNumber();
        Long b = calculationRequest.getSecondNumber();
        if (b == 0) {
            throw new InvalidOperationException("Division by zero is not allowed");
        }
        return a / b;
    }
}
