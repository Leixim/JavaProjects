package mathoperations;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws Exception{
        System.out.println("Enter value for calculate factorial");
        int inputValue = readInt();
        System.out.println("Factorial = " + factorialR(inputValue));
        System.out.println("Factorial = " + factorial(inputValue));
    }

    public static long factorialR(Integer value) {
        return (value == 0) ? 1 : value * factorialR(value - 1);
    }

    public static long factorial(Integer value) {
        long factorial = 1L;
        for (int i = 1; i <=value ; i++) {
            factorial= factorial*i;
        }
        return factorial;
    }


    private static int readInt() throws Exception {
        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                result = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Enter the number");
            } finally {
                reader.close();
            }
        }
        return result;
    }
}
