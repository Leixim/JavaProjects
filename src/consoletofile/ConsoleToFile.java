package consoletofile;

import java.io.*;
import java.util.Scanner;

public class ConsoleToFile {
    public static final String KEYWORD_FOR_EXIT = "-exit";
    public static final String INPUT_FILENAME = "output.txt";
    public static final String CHARSET_NAME = "UTF-8";

    public static void main(String[] args) throws Exception {
        System.out.println("App was started. Enter '" + KEYWORD_FOR_EXIT + "' to exit.");
        System.out.println("Enter new line...");
        try (Scanner sc = new Scanner(System.in);) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (isStopTheApp(line)) {
                    break;
                }
                try {
                    writeNewLineToFile(line);
                } catch (FileNotFoundException e) {
                    System.out.println("File was not found " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Access file error " + e.getMessage());
                }
                System.out.println("Enter new line...");
            }
        }
        System.out.println("App was stopped");
    }

    private static void writeNewLineToFile(String line) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(INPUT_FILENAME, true);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CHARSET_NAME);
             PrintWriter writer = new PrintWriter(outputStreamWriter);) {
            writer.println(line);
        }
    }

    private static boolean isStopTheApp(String line) {
        return line.equals(KEYWORD_FOR_EXIT);
    }
}
