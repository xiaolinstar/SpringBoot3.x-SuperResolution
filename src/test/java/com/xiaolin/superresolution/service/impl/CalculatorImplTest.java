package com.xiaolin.superresolution.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {
    private final CalculatorImpl calculator;
    public CalculatorImplTest() {
        this.calculator = new CalculatorImpl();
    }
    @Test
    void addTwoNumbers() {
        assertEquals(10, calculator.addTwoNumbers(2, 8));
//        assertEquals(12, calculator.addTwoNumbers(2, 8));
    }

    @Test
    void productTwoNumbers() {
        assertEquals(20, calculator.productTwoNumbers(1, 20));
//        assertEquals(20, calculator.productTwoNumbers(3, 20));
    }
}