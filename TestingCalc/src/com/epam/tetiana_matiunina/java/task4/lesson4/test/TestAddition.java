package com.epam.tetiana_matiunina.java.task4.lesson4.test;

import com.epam.tetiana_matiunina.java.task4.lesson4.operation.Addition;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;



public class TestAddition {
    private Addition additon;




    @Before
    public void setUp(){
        additon = new Addition();

    }

    @Test
    public void testAddOperate(){
        double sum = additon.operate(1,2);
        assertEquals(3.0, sum,1e-15);

    }

    @Test
    public void testAddOperateWithNegativeNumber(){
        double sum = additon.operate(-2,-10);
        assertEquals(-12.0, sum,1e-15);
    }

    @Test
    public void testAddOperateWithDoubleNumber(){

        double sum = additon.operate(2.1,2.1);
        assertEquals(4.2, sum,1e-15);
    }
    @Test
    public void testAddOperateWithNegativeDoubleNumber(){

        double sum = additon.operate(-2.1,-2.1);
        assertEquals(-4.2, sum,1e-15);
    }

    @Test
    public void testAddOperateMaxDoubleValue(){

        double sum = additon.operate(Double.MAX_VALUE,Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE+Double.MAX_VALUE, sum,1e-15);
    }


    @Test
    public void testAddOperateMaxDoubleValueAndMinDoubleValue(){

        double sum = additon.operate(Double.MAX_VALUE,Double.MIN_VALUE);
        assertEquals(Double.MAX_VALUE+Double.MIN_VALUE, sum,1e-15);
    }
    @Test
    public void testAddOperateZeroAndPositiveNumber(){

        double sum = additon.operate(0,3);
        assertEquals(3.0, sum,1e-15);
    }
    @Test
    public void testAddOperateZeroAndNegativeNumber(){

        double sum = additon.operate(0,-3);
        assertEquals(-3.0, sum,1e-15);
    }
    @Test
    public void testAddOperatePositiveNumberAndNegativeNumber(){

        double sum = additon.operate(3,-3);
        assertEquals(0.0, sum,1e-15);
    }

    @Test
    public void testAddOperation(){

        for (int i=-100; i<101; i++ ){
        double sum = additon.operate(i,i);
        assertEquals(i+i, sum,1e-15);
        }
    }




}
