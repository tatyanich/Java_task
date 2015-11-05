package com.epam.tetiana_matiunina.java.task4.lesson4.test;

import com.epam.tetiana_matiunina.java.task4.lesson4.Calculator;
import com.epam.tetiana_matiunina.java.task4.lesson4.operation.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * Created by Tetiana_Matiunina on 27.10.2015.
 */
public class TestCalculator {
    Calculator calculator;


    @Before
    public void setUp() {
        calculator = new Calculator();
        calculator.addOperation(new Addition());
        calculator.addOperation(new Division());
        calculator.addOperation(new Multiplication());
        calculator.addOperation(new Subtraction());
    }

    @Test
    public void testAddOperation() {
        double res = calculator.calculate("+", 1, 1);
        assertEquals(2.0, res, 1e-15);
    }

    @Test
    public void testSubtractOperation() {
        double res = calculator.calculate("-", 1, 1);
        assertEquals(0.0, res, 1e-15);
    }

    @Test
    public void testDivisionOperation() {
        double res = calculator.calculate("/", 1, 1);
        assertEquals(1.0, res, 1e-15);
    }

    @Test
    public void testMultiplyOperation() {
        double res = calculator.calculate("*", 2.2, 1);
        assertEquals(2.2, res, 1e-15);
    }

    @Rule
    public ExpectedException thrownInvalidOperator = ExpectedException.none();

    @Test
    public void testInvalidOperationException() {
        thrownInvalidOperator.expect(IllegalArgumentException.class);
        thrownInvalidOperator.expectMessage("No any operation");
        calculator.calculate("%", 2.2, 1);
    }

    @Test
    public void testDivisionByZero() {
        double res = calculator.calculate("/", 2.2, 0);
        assertEquals(Double.NaN, res, 1e-15);
    }

    @Rule
    public ExpectedException thrownNullOperator = ExpectedException.none();

    @Test
    public void testDivisionWithNullOperator() {
        thrownNullOperator.expect(IllegalArgumentException.class);
        thrownNullOperator.expectMessage("No any operation");
        double res = calculator.calculate(null, 2.2, 0);
        assertEquals(Double.NaN, res, 1e-15);
    }
}
