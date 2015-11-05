package com.epam.tetiana_matiunina.java.task4.lesson4.test;

import  com.epam.tetiana_matiunina.java.task4.lesson4.operation.Subtraction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tetiana_Matiunina on 25.10.2015.
 */
public class TestSubtraction {
    private Subtraction subtraction;

    @Before
    public void setUp(){

        subtraction=new Subtraction();

    }

    @Test
    public void testSubtractionOperate(){

        double sum = subtraction.operate(3,2);
        assertEquals(1.0, sum,1e-15);
    }

    @Test
    public void testAddOperateWithNegativeNumber(){
        double sum = subtraction.operate(-2,-10);
        assertEquals(8.0, sum,1e-15);
    }

    @Test
    public void testAddOperateWithDoubleNumber(){

        double sum = subtraction.operate(2.1,2.1);
        assertEquals(0.0, sum,1e-15);
    }
    @Test
    public void testSubtractionOperateWithNegativeDoubleNumber(){

        double sum = subtraction.operate(-3.1,-2.1);
        assertEquals(-1.0, sum,1e-15);
    }

    @Test
    public void testSubtractionOperateMaxDoubleValue(){

        double sum = subtraction.operate(Double.MAX_VALUE,Double.MAX_VALUE);
        assertEquals(0.0, sum,1e-15);
    }


    @Test
    public void testSubtractionOperateMaxDoubleValueAndMinDoubleValue(){

        double sum = subtraction.operate(Double.MAX_VALUE,Double.MIN_VALUE);
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, sum,1e-15);
    }
    @Test
    public void testSubtractionOperateZeroAndPositiveNumber(){

        double sum = subtraction.operate(0,100);
        assertEquals(-100.0, sum,1e-15);
    }
    @Test
    public void testSubtractionOperateZeroAndNegativeNumber(){

        double sum = subtraction.operate(0,-200);
        assertEquals(200.0, sum,1e-15);
    }
    @Test
    public void testSubtractionOperatePositiveNumberAndNegativeNumber(){

        double sum = subtraction.operate(3,-3);
        assertEquals(6.0, sum,1e-15);
    }

    @Test
    public void testSubtractionOperation(){

        for (int i=-100; i<101; i++ ){
            double sum = subtraction.operate(i,i);
            assertEquals(i-i, sum,1e-15);
        }
    }

}
