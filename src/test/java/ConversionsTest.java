import Logic.Conversions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConversionsTest {
    Conversions test = new Conversions();
    @Test
    public void decToQuatTest(){
        int input = 153;
        Assertions.assertEquals("2121", test.decToQuat(input));
    }
    @Test
    public void quatToDecTest(){
        String input = "2121";
        Assertions.assertEquals(153, test.quatToDec(input));
    }
    @Test
    public void backAndForthTest(){
        int input = 579;
        String quatFromInput = test.decToQuat(input);
        Assertions.assertEquals(input, test.quatToDec(quatFromInput));
    }
}
