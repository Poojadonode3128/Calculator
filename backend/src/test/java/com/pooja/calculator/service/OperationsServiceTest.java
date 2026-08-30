package com.pooja.calculator.service;

import com.pooja.calculator.exception.InvalidOperationException;
import com.pooja.calculator.dto.CalculationRequest;
import com.pooja.calculator.repository.CalculationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class OperationsServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @InjectMocks
    private OperationsService operationsService;

    @Test
    void testAdd() {
        CalculationRequest request = new CalculationRequest(5L, 3L);
        Long value = operationsService.add(request);
        assertEquals(8, value);
    }

    @Test
    void testSubtract() {
        CalculationRequest request = new CalculationRequest(5L, 3L);
        Long value = operationsService.subtract(request);
        assertEquals(2, value);
    }

    @Test
    void testMultiply() {
        CalculationRequest request = new CalculationRequest(5L, 3L);
        Long value = operationsService.multiply(request);
        assertEquals(15, value);
    }

    @Test
    void testDivide() {
        CalculationRequest request = new CalculationRequest(6L, 3L);
        Long value = operationsService.divide(request);
        assertEquals(2, value);
    }

    @Test
    void testDivideByZero() {
        CalculationRequest request = new CalculationRequest(6L, 0L);
        InvalidOperationException exception = assertThrows(InvalidOperationException.class, () -> operationsService.divide(request));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
