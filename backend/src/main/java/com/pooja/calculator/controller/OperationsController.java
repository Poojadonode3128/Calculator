package com.pooja.calculator.controller;

import com.pooja.calculator.dto.CalculationRequest;
import com.pooja.calculator.service.OperationsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationsController {

    private final OperationsService operationsService;

    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody CalculationRequest calculationRequest) {
        Long result =operationsService.add(calculationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("The addition operation has been executed successfully: "+result);
    }

    @PostMapping("/subtract")
    public ResponseEntity<String> subtract(@Valid @RequestBody CalculationRequest calculationRequest) {
        Long result = operationsService.subtract(calculationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("The substraction operation has been executed successfully: "+result);
    }

    @PostMapping("/multiply")
    public ResponseEntity<String> multiply(@Valid @RequestBody CalculationRequest calculationRequest) {
        Long result = operationsService.multiply(calculationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("The multiplication operation has been executed successfully: "+result);
    }

    @PostMapping("/divide")
    public ResponseEntity<String> divide(@Valid @RequestBody CalculationRequest calculationRequest) {
        Long result = operationsService.divide(calculationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("The divide operation has been executed successfully: "+result);
    }
}
