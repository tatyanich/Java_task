package com.epam.tetiana_matiunina.java.task4.lesson4.test;

import com.epam.tetiana_matiunina.java.task4.lesson4.operation.Division;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tetiana_Matiunina on 25.10.2015.
 */
public class TestDivision {
    private Division division;

    @Before
    public void setUp() {
        division = new Division();
    }

    @Test
    public void testDivisionOperate() {
        double sum = division.operate(10, 1);
        assertEquals(10.0, sum, 1e-15);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZeroOperate() {
        double sum = division.operate(1, 0);
        assertEquals(Double.NaN, sum, 1e-15);
    }

    @Test
    public void testDivisionOperateWithNegative() {
        double sum = division.operate(-1, -1);
        assertEquals(1.0, sum, 1e-15);
    }

    @Test
    public void testDivisionOperateWithNegativeDouble() {
        double sum = division.operate(-1.2, -1.2);
        assertEquals(1.0, sum, 1e-15);
    }

    @Test
    public void testDivisionOperateWithDouble() {
        double sum = division.operate(2.2, 2.2);
        assertEquals(1.0, sum, 1e-15);
    }
    @Test
    public void testDivisionOperateWithBigNumbers(){
        double sum = division.operate(Double.MAX_VALUE,Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE/Double.MAX_VALUE, sum,1e-15);
    }


     @Test
    public void testDivisionOperateMaxDoubleValueAndMinDoubleValue(){

        double sum = division.operate(Double.MAX_VALUE,Double.MIN_VALUE);
        assertEquals(Double.MAX_VALUE/Double.MIN_VALUE, sum,1e-15);
    }
    @Test
    public void testDivisionOperateZeroAndPositiveNumber(){

        double sum = division.operate(0,100);
        assertEquals(0.0, sum,1e-15);
    }
    @Test
    public void testDivisionOperateZeroAndNegativeNumber(){

        double sum = division.operate(0,-200);
        assertEquals(-0.0, sum,1e-15);
    }
    @Test
    public void testDivisionOperatePositiveNumberAndNegativeNumber(){

        double sum = division.operate(3,-3);
        assertEquals(-1.0, sum,1e-15);
    }






}
