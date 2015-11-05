//package com.epam.tetiana_matiunina.java.lesson4.task4.test;
//
///**
// * Created by Tetiana_Matiunina on 05.11.2015.
// */
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import com.epam.tetiana_matiunina.java.lesson4.task4.Demo;
//
//import com.epam.tetiana_matiunina.java.lesson4.task4.StringCalculator;
//import com.epam.tetiana_matiunina.java.lesson4.task4.exception.NullStringException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by Tetiana_Matiunina on 05.11.2015.
// */
//public class TestDemo {
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private StringCalculator calculator;
//
//    @Before
//    public void setUp() {
//        System.setOut(new PrintStream(outContent));
//        calculator = new StringCalculator();
//    }
//
//    @After
//    public void cleanUpStreams() {
//        System.setOut(null);
//    }
//
//    @Test
//    public void testAddExpressionWithTwoOperand()throws NullStringException {
//        Demo.main(new String[]{"1,2"});
//        System.out.print(calculator.add("1,2"));
//        assertEquals("3", outContent.toString());
//    }
//
//    @Test
//    public void testAddEmptyExpression()throws NullStringException {
//        Demo.main(new String[]{""});
//        System.out.print(calculator.add(""));
//        assertEquals("0", outContent.toString());
//    }
//
//    @Test
//    public void testAddExpressionWithOneOperand() throws NullStringException{
//        Demo.main(new String[]{"2"});
//        System.out.print(calculator.add("2"));
//        assertEquals("2", outContent.toString());
//    }
//
//
//    @Test
//    public void testAddExpressionWithMultiOperand() throws NullStringException{
//        Demo.main(new String[]{"1,2,3"});
//        System.out.print(calculator.add("1,2,3"));
//        assertEquals("6", outContent.toString());
//    }
//
//    @Test(expected = NumberFormatException.class)
//    public void testOperateNotNumber() throws NullStringException {
//        // thrown.expect(NumberFormatException.class);
//        //Demo.main(new String[]{"v,v"});
//        calculator.add("v,1");
//    }
//
//
//    @Rule
//    public ExpectedException thrown = ExpectedException.none();
//
//    @Test
//    public void testExceptionWhenNegativeNumbersAreUsed() throws NullStringException{
//// arrange
//        thrown.expect(IllegalArgumentException.class);
//        thrown.expectMessage("negatives not allowed: [-1, -3]");
//// act
//        Demo.main(new String[]{"-1,2,-3"});
//        System.out.print(calculator.add("-1,2,-3"));
//        assertEquals("negatives not allowed: [-1, -3]\n", outContent.toString());
//    }
//
//    @Test
//    public void testResultWithNumberBiggerThen1000() throws NullStringException{
//        Demo.main(new String[]{"1,1001,1"});
//        System.out.print(calculator.add("1,1001,1"));
//        assertEquals("2", outContent.toString());
//    }
//
//    @Test
//    public final void testWhenNewLineUsedBetweenNumbers()throws NullStringException {
//        Demo.main(new String[]{"3,6\n15"});
//        System.out.print(calculator.add("3,6\n15"));
//        assertEquals("24",  outContent.toString());
//    }
//
//    @Test
//    public void testInputStringWithDelimiters() throws NullStringException{
//        Demo.main(new String[]{"//;\n1;2"});
//        System.out.print(calculator.add("//;\n1;2"));
//        assertEquals("3",  outContent.toString());
//    }
//
//    @Test
//    public void testInputStringWithDelimitersOfAnyLength()throws NullStringException {
//        Demo.main(new String[]{"//[****]\n1****2"});
//        System.out.print(calculator.add("//[****]\n1****2"));
//        assertEquals("3",  outContent.toString());
//    }
//
//    @Test
//    public void testInputStringWithMultiplyDelimiters() throws NullStringException{
//        Demo.main(new String[]{"//[*][;]\n1;2"});
//        System.out.print(calculator.add("//[*][;]\n1;2"));
//        assertEquals("3",  outContent.toString());
//    }
//
//    @Rule
//    public ExpectedException thrownNull = ExpectedException.none();
//
//    @Test
//    public void testExceptionWhenNullString() throws NullStringException {
//// arrange
//        thrownNull.expect(NullStringException.class);
//        thrownNull.expectMessage("string couldn't be null!");
//// act
//        Demo.main(new String[]{"-1,2,-3"});
//        calculator.add(null);
//        //assertEquals("negatives not allowed: [-1, -3]\n", outContent.toString());
//    }
//
//}
