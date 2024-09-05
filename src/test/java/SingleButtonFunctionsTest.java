import Logic.SingleButtonFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleButtonFunctionsTest {
    SingleButtonFunctions test = new SingleButtonFunctions();

    @Test
    public void squarerootTest(){
        int num1 = 4;
        Assertions.assertEquals(2, test.squareroot(num1));
    }

    @Test
    public void squaredTest(){
        int num1 = 4;
        Assertions.assertEquals(16, test.squared(num1));
    }
}
