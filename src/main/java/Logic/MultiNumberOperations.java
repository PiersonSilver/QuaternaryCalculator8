package Logic;

public class MultiNumberOperations {
    public String calculate(String quat1, String operand, String quat2){
        Conversions converter = new Conversions();
        int num1 = converter.quatToDec(quat1);
        int num2 = converter.quatToDec(quat2);
        int result = switch(operand){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
        return converter.decToQuat(result);
    }
}
