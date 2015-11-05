package test;

import static org.junit.Assert.assertEquals;

import com.epam.tetiana_matiunina.java.lesson4.task4.StringCalculator;
import com.epam.tetiana_matiunina.java.lesson4.task4.exception.NullStringException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Tetiana_Matiunina on 23.10.2015.
 */
public class TestStringCalculator {
    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void testAddEmptyExpression()throws NullStringException {

        int sum = calculator.add("");
        assertEquals(0, sum);
    }

    @Test
    public void testAddExpressionWithOneOperand()throws NullStringException {
        int sum = calculator.add("2");
        assertEquals(2, sum);
    }

    @Test
    public void testAddExpressionWithTwoOperand() throws NullStringException{
        int sum = calculator.add("1,2");
        assertEquals(3, sum);
    }

    @Test
    public void testAddExpressionWithMultiOperand() throws NullStringException{

        int sum = calculator.add("1,2,3");
        assertEquals(6, sum);
    }

    @Test(expected = RuntimeException.class)
    public void testOperateNotNumber() throws NullStringException{
        String stringWithNotNumbers = "v,v";
        calculator.add(stringWithNotNumbers);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptionWhenNegativeNumbersAreUsed()throws NullStringException {
// arrange
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("negatives not allowed: [-1, -3]");
// act
        String stringWithNegativeNumbers = "-1,2,-3";
        calculator.add(stringWithNegativeNumbers);
    }

    @Test
    public void testResultWithNumberBiggerThen1000() throws NullStringException {
        int sum = calculator.add("1,1001,1");
        assertEquals(2, sum);
    }

    @Test
    public final void testWhenNewLineUsedBetweenNumbers()throws NullStringException {
        int sum = calculator.add("3,6\n15");
        assertEquals(3 + 6 + 15, sum);
    }

    @Test
    public void testInputStringWithDelimiters()throws NullStringException {

        int sum = calculator.add("//;\n1;2");
        assertEquals(3, sum);
    }

    @Test
    public void testInputStringWithDelimitersOfAnyLength() throws NullStringException{

        int sum = calculator.add("//[****]\n1****2");
        assertEquals(3, sum);
    }

    @Test
    public void testInputStringWithMultiplyDelimiters() throws NullStringException{
        int sum = calculator.add("//[*][;]\n1;2");
        assertEquals(3, sum);
    }

    @Rule
    public ExpectedException thrownNull = ExpectedException.none();

    @Test
    public void testInputStringNull() throws NullStringException{
        thrownNull.expect(NullStringException.class);
        thrownNull.expectMessage("string couldn't be null!");
        calculator.add(null);
    }


}



