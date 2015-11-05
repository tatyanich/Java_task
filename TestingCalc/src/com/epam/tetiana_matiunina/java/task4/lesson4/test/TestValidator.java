package com.epam.tetiana_matiunina.java.task4.lesson4.test;

import  com.epam.tetiana_matiunina.java.task4.lesson4.Parser;
import  com.epam.tetiana_matiunina.java.task4.lesson4.operation.*;
import  com.epam.tetiana_matiunina.java.task4.lesson4.validator.Validator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tetiana_Matiunina on 27.10.2015.
 */
public class TestValidator {
    EMathOperations[] operations ;
    String operatorsCheck;
    @Before
    public void setUp(){
        operations = EMathOperations.values();
        operatorsCheck = operations[0].getMathOperations() + operations[1].getMathOperations()
                + operations[2].getMathOperations() + operations[3].getMathOperations();
    }

    @Test
    public void testExpressionStringLengthLessThen3(){
        String [] array = Parser.parseExpression("1");
        String result = "Invalid mathematical expression. It must be number operand number.Possible operands: " + operatorsCheck;
        String validate = Validator.validate(array);
        assertEquals(result, validate);
    }

    @Test
    public void testExpressionStringLengthGreaterThen3(){
        String [] array = Parser.parseExpression("1+7+9");
        String result = "Invalid mathematical expression. Can calculate only two positive numbers";
        String validate = Validator.validate(array);
        assertEquals(result, validate);

    }
    @Test
    public void testExpressionStringWithInvalidFirstOperand(){
        String [] array = Parser.parseExpression("1=+7");
        String result = "Invalid operator " + array[0];
        String validate = Validator.validate(array);
        assertEquals(result, validate);

    }
    @Test
    public void testExpressionStringWithInvalidSecondOperand(){
        String [] array = Parser.parseExpression("1+7&");
        String result = "Invalid operator " + array[2];
        String validate = Validator.validate(array);
        assertEquals(result, validate);

    }
    @Test
    public void testRightStringExpression(){
        String [] array = Parser.parseExpression("1+7");

        String validate = Validator.validate(array);
        assertEquals("", validate);

    }

    @Test
    public void testEmptyExpressionString(){
        String [] array = Parser.parseExpression("");
        String validate = Validator.validate(array);
        assertEquals("Invalid mathematical expression. It must be number operand number.Possible operands: "+operatorsCheck, validate);

    }

    @Ignore("not ready to use")
    @Test
    public void testNullExpression(){
        String [] array = Parser.parseExpression(null);
        String validate = Validator.validate(array);
        assertEquals("Null is not possible",validate);

    }




}
