package threads.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;


public class MainApp extends Thread{
    public static int sizeOfCollection;

    public static void main(String[] args) throws Exception {
        System.out.println("Enter size of collection");
        sizeOfCollection = readInt();
        if (sizeOfCollection <= 0) {
            throw new InvalidSizeOfCollection("Size of collection is incorrect");
        }
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue();
        Task task = new Task(queue);
        for (int i = 0; i < sizeOfCollection*4 ; i++) {
            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);
            Thread thread3 = new Thread(task);
            Thread thread4 = new Thread(task);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            System.out.println(queue);
        }
        System.out.println("*****Final QUEUE*********");
        System.out.println(queue);
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


    static class InvalidSizeOfCollection extends Exception {
        public InvalidSizeOfCollection(String message) {
            super(message);
            System.err.println("*****************");
        }
    }
}
