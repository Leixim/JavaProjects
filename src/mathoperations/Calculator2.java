package mathoperations;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = reader.readLine();
        String firstInputValue = "";
        String secondInputValue = "";
        char operation;
        int indexOfString = 0;
        while ((inputValue.charAt(indexOfString) != '+') && (inputValue.charAt(indexOfString) != '-') && (inputValue.charAt(indexOfString) != '*') && (inputValue.charAt(indexOfString) != '/') && (inputValue.charAt(indexOfString) != '%')) {
            if ((inputValue.charAt(indexOfString) != ' ') && (Character.isDigit(inputValue.charAt(indexOfString))) || (inputValue.charAt(indexOfString) == '.')) {
                firstInputValue = firstInputValue + inputValue.charAt(indexOfString);
            }
            indexOfString++;
        }

        operation = inputValue.charAt(indexOfString);
        indexOfString++;

        while ((indexOfString < inputValue.length()) && (inputValue.charAt(indexOfString) != '+') && (inputValue.charAt(indexOfString) != '-') && (inputValue.charAt(indexOfString) != '*') && (inputValue.charAt(indexOfString) != '/') && (inputValue.charAt(indexOfString) != '%')) {
            if ((inputValue.charAt(indexOfString) != ' ') && (Character.isDigit(inputValue.charAt(indexOfString))) || (inputValue.charAt(indexOfString) == '.')) {
                secondInputValue = secondInputValue + inputValue.charAt(indexOfString);
            }
            indexOfString++;
        }
        if (true) {
            try {
                Double.parseDouble(firstInputValue);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input first number. ");
            }
        }
        if (true) {
            try {
                Double.parseDouble(secondInputValue);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input second number. ");
            }
        }
        System.out.println("Entered number 1: " + Double.parseDouble(firstInputValue));
        System.out.println("Entered number 2: " + Double.parseDouble(secondInputValue));


        switch (operation) {
            case '+':
                System.out.println("Sum of the entered numbers: " + (Double.parseDouble(firstInputValue) + Double.parseDouble(secondInputValue)));
                break;
            case '-':
                System.out.println("Subtraction of the entered numbers: " + (Double.parseDouble(firstInputValue) - Double.parseDouble(secondInputValue)));
                break;
            case '*':
                System.out.println("Multiplication of the entered numbers: " + (Double.parseDouble(firstInputValue) * Double.parseDouble(secondInputValue)));
                break;
            case '/':
                System.out.println("Multiplication of the entered numbers: " + (Double.parseDouble(firstInputValue) / Double.parseDouble(secondInputValue)));
                break;
            case '%':
                System.out.println("Remainder of the division of the entered numbers: " + (Double.parseDouble(firstInputValue) % Double.parseDouble(secondInputValue)));
                break;
        }
    }
}
