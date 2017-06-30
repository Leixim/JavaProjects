package mathoperations;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculatorFromString {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = reader.readLine();
        parseDouble(inputValue);
    }

    public static void operations(String operator, double firstValue, double secondValue) {
        switch (operator) {
            case "+":
                System.out.println("Sum of the entered numbers: " + (firstValue + secondValue));
                break;
            case "-":
                System.out.println("Subtraction of the entered numbers: " + (firstValue - secondValue));
                break;
            case "*":
                System.out.println("Multiplication of the entered numbers: " + (firstValue * secondValue));
                break;
            case "/":
                System.out.println("Division of the entered numbers: " + (firstValue / secondValue));
                break;
            case "%":
                System.out.println("Remainder of the division of the entered numbers: " + (firstValue % secondValue));
                break;
            default:
                System.out.println("Error in entered operation");
                break;
        }
    }

    public static void parseDouble(String inputValue) {
        double firstValue, secondValue;
        String operation;
        String[] arithmeticOperations = {"+", "-", "*", "/", "%"};
        for (String value : arithmeticOperations) {
            if (inputValue.contains(value)) {
                firstValue = Double.parseDouble(inputValue.substring(0, inputValue.indexOf(value)));
                secondValue = Double.parseDouble(inputValue.substring(inputValue.indexOf(value) + 1, inputValue.length()));
                operation = value;
                operations(operation, firstValue, secondValue);
            }
        }
    }
}

