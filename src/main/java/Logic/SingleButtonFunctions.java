package Logic;

public class SingleButtonFunctions {
    Conversions conversions = new Conversions();
    public String calculate(String quat1, String operand){
        int num1 = conversions.quatToDec(quat1);
        int result = switch(operand){
            case "root" -> (int)Math.sqrt(num1);
            case "sqr" -> (int)Math.pow(num1, 2);
            default -> 0;
        };
        return conversions.decToQuat(result);
    }

}
