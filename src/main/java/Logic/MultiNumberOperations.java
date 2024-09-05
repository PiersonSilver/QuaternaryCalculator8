package Logic;

public class MultiNumberOperations {
    public String calculate(String quat1, String operand, String quat2){
        Conversions converter = new Conversions();
        SingleButtonFunctions functions = new SingleButtonFunctions();
        int num1 = converter.quatToDec(quat1);
        int num2 = converter.quatToDec(quat2);
        int result = switch(operand){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "^" -> functions.squared(num1);
            case "%" -> functions.squareroot(num1);
            default -> 0;
        };
        return converter.decToQuat(result);
    }
}
