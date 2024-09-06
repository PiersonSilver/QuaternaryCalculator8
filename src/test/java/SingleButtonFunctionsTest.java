import Logic.SingleButtonFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleButtonFunctionsTest {
    SingleButtonFunctions test = new SingleButtonFunctions();

    @Test
    public void squareRootTest(){
        String quat = "21";//9
        Assertions.assertEquals("3" /*4*/, test.calculate(quat, "root"));
    }

    @Test
    public void squaredTest(){
        String quat = "11";//5
        Assertions.assertEquals("121" /*25*/, test.calculate(quat, "sqr"));
    }
}
