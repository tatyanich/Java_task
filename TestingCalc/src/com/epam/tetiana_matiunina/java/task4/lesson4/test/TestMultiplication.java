package com.epam.tetiana_matiunina.java.task4.lesson4.test;


import  com.epam.tetiana_matiunina.java.task4.lesson4.operation.Multiplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tetiana_Matiunina on 25.10.2015.
 */
public class TestMultiplication {
    private Multiplication multiplication;
    @Before
    public void setUp(){

        multiplication = new Multiplication();
    }

    @Test
    public void testMultiplicationOperate(){

        double sum = multiplication.operate(2,4);
        assertEquals(8.0, sum,1e-15);
    }

    @Test
    public void testMultiplicationOperateWithBigNumbers(){

        double sum = multiplication.operate(Double.MAX_VALUE,Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE*Double.MAX_VALUE, sum,1e-15);
    }

    @Test
    public void testMultiplicationOperateWithDoubleNumber(){

        double sum = multiplication.operate(5.2,8.2);
        assertEquals(42.64, sum,1e-15);
    }
    @Test
    public void testMultiplicationOperateWithNegativeDoubleNumber(){

        double sum = multiplication.operate(-5.2,-8.2);
        assertEquals(42.64, sum,1e-15);
    }

       @Test
    public void testMultiplicationOperateMaxDoubleValueAndMinDoubleValue(){

        double sum = multiplication.operate(Double.MAX_VALUE,Double.MIN_VALUE);
        assertEquals(Double.MAX_VALUE*Double.MIN_VALUE, sum,1e-15);
    }
    @Test
    public void testMultiplicationOperateZeroAndPositiveNumber(){

        double sum = multiplication.operate(0,100);
        assertEquals(0.0, sum,1e-15);
    }
    @Test
    public void testMultiplicationOperateZeroAndNegativeNumber(){

        double sum = multiplication.operate(0,-200);
        assertEquals(0.0, sum,1e-15);
    }
    @Test
    public void testMultiplicationOperatePositiveNumberAndNegativeNumber(){

        double sum = multiplication.operate(3,-3);
        assertEquals(-9.0, sum,1e-15);
    }

    @Test
    public void testMultiplicationOperation(){

        for (int i=-100; i<101; i++ ){
            double sum = multiplication.operate(i,i);
            assertEquals(i*i, sum,1e-15);
        }
    }

}

