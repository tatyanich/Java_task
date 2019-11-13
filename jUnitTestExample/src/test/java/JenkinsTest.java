import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JenkinsTest {

    @Test
    public void FirstTest(){
        assertEquals(1,1);
    }

    @Test
    public void SecondTest(){
        assertEquals(2,1);
    }

    @Test
    @Ignore
    public void ThirdTest(){
        assertEquals(1,1);
    }

    @Test
    public void ForthTest(){
        assertEquals(1,1);
    }
}
