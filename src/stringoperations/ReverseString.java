package stringoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static String reverseString(String string) {
        char[] arrayOfChar = string.toCharArray();
        for (int i = 0; i <arrayOfChar.length/2; i++) {
            char temp = arrayOfChar[i];
            arrayOfChar[i] = arrayOfChar[arrayOfChar.length-i-1];
            arrayOfChar[arrayOfChar.length-i-1] = temp;
        }
        return new String(arrayOfChar);
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter text line:");
            String inputText = bufferedReader.readLine();
            System.out.println("Result of reversing :");
            System.out.println(reverseString(inputText));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


