package readfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {
        //Read file Scanner
        try {
            Scanner scanner = new Scanner(new FileInputStream("persons.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("***************************");
        //Read file NIO
        try {
            List<String> stringList = Files.readAllLines(Paths.get("persons.txt"));
            for (String s : stringList) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("***************************");

        try {
            Files.lines(Paths.get("persons.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
