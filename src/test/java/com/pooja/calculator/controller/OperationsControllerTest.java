package com.pooja.calculator.controller;

import com.pooja.calculator.dto.CalculationRequest;
import com.pooja.calculator.service.OperationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationsControllerTest {

    @Mock
    private OperationsService operationsService;

    @InjectMocks
    private OperationsController operationsController;

    @Test
    void testAdd() {

        CalculationRequest request =
                new CalculationRequest(5L, 3L);

        when(operationsService.add(request))
                .thenReturn(8L);

        ResponseEntity<String> result = operationsController.add(request);

        assertEquals("The addition operation has been executed successfully: 8", result.getBody());
    }

    @Test
    void testSubtract() {

        CalculationRequest request = new CalculationRequest(5L, 3L);

        when(operationsService.subtract(request)).thenReturn(2L);

        ResponseEntity<String> result = operationsController.subtract(request);

        assertEquals("The substraction operation has been executed successfully: 2", result.getBody());
    }

    @Test
    void testMultiply() {

        CalculationRequest request = new CalculationRequest(5L, 3L);

        when(operationsService.multiply(request)).thenReturn(15L);

        ResponseEntity<String> result = operationsController.multiply(request);

        assertEquals("The multiplication operation has been executed successfully: 15", result.getBody());
    }

    @Test
    void testDivide() {
        CalculationRequest request = new CalculationRequest(6L, 3L);

        when(operationsService.divide(request)).thenReturn(2L);

        ResponseEntity<String> result = operationsController.divide(request);
        assertEquals("The divide operation has been executed successfully: 2", result.getBody());
    }

}
