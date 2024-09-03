import Logic.MultiNumberOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiNumberOperationsTest {
    MultiNumberOperations test = new MultiNumberOperations();
    @Test
    public void additionTest(){
        String quat1 = "210"; //36
        String quat2 = "22"; //10
        Assertions.assertEquals("232", test.calculate(quat1, "+", quat2));
    }
    @Test
    public void subtractionTest(){
        String quat1 = "210"; //36
        String quat2 = "22"; //10
        Assertions.assertEquals("122", test.calculate(quat1, "-", quat2));
    }
    @Test
    public void multiplicationTest(){
        String quat1 = "210"; //36
        String quat2 = "22"; //10
        Assertions.assertEquals("11220", test.calculate(quat1, "*", quat2));
    }@Test
    public void divisionTest(){
        String quat1 = "210"; //36
        String quat2 = "22"; //10
        Assertions.assertEquals("3", test.calculate(quat1, "/", quat2));
    }

}
