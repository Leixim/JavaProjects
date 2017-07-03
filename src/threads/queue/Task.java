package threads.queue;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Task implements Runnable {
    ConcurrentLinkedQueue<Integer> queue;

    public Task(ConcurrentLinkedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            if (queue.size() < MainApp.sizeOfCollection) {
                Random random = new Random();
                Thread.sleep(900);
                int randomValue = random.nextInt(99) + 1;
                queue.add(randomValue);
                System.out.println(MainApp.currentThread().getName() + " input in queue value: " + randomValue);
            }
            if (queue.size() == MainApp.sizeOfCollection) {
                queue.remove();
                Random random = new Random();
                Thread.sleep(900);
                int randomValue = random.nextInt(99) + 1;
                queue.add(randomValue);
                System.out.println(MainApp.currentThread().getName() + " input in queue value: " + randomValue);

            }
            if (queue.size() > MainApp.sizeOfCollection) {
                queue.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
