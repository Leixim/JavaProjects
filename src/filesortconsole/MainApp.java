package filesortconsole;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainApp {

        public static final String KEYWORD_FOR_EXIT = "-stop";

        public static void main(String[] args) {
            System.out.println("Persons loading...");
            PersonExtractor personExtractor = new PersonExtractor().invoke();
            if (personExtractor.wasError()) {
                System.out.println("App was stopped");
                return;
            }
            System.out.println("Persons were loaded.");
            System.out.println("App was started. Enter '" + KEYWORD_FOR_EXIT + "' to exit.");
            processCommand(personExtractor);
            System.out.println("App was stopped");
        }

        private static void processCommand(PersonExtractor personExtractor) {
            System.out.println("Enter one of these commands '-f' '-s' '-a'...");
            System.out.println("-f : sort by name");
            System.out.println("-s : sort by lastname");
            System.out.println("-a : sort by age");
            List<Person> persons = personExtractor.getPersons();
            try (Scanner sc = new Scanner(System.in);) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (isStopTheApp(line)) {
                        break;
                    }
                    if (line.equals("-f")) {
                        Collections.sort(persons, new FirstNameComparator());
                    } else if (line.equals("-s")) {
                        Collections.sort(persons, new LastNameComparator());
                    } else if (line.equals("-a")) {
                        Collections.sort(persons, new AgeComparator());
                    }
                    printList(persons);
                    System.out.println("Enter one of these commands '-f' '-s' '-a'...");
                }
            }
        }

        private static void printList(List<Person> persons) {
            persons.forEach(System.out::println);
        }

        private static boolean isStopTheApp(String line) {
            return line.equals(KEYWORD_FOR_EXIT);
        }
    }

