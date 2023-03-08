package com.xiaolin.superresolution.service.impl;

import com.xiaolin.superresolution.service.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author xlxing
 */
@Service
public class CalculatorImpl implements Calculator {
    @Override
    public int addTwoNumbers(int a, int b) {
        return a+b;
    }

    @Override
    public int productTwoNumbers(int a, int b) {
        return a*b;
    }
}
