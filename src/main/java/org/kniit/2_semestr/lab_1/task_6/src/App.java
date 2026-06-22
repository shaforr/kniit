import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        int numRunners = args.length > 0 ? Integer.parseInt(args[0]) : 5;
        System.out.println("На старт выходят " + numRunners + " бегунов.\n");


        CyclicBarrier startBarrier = new CyclicBarrier(numRunners, () -> 
            System.out.println("СТАРТ! Все бегуны готовы, поехали!\n")
        );

        CountDownLatch finishLatch = new CountDownLatch(numRunners);

        ExecutorService executor = Executors.newFixedThreadPool(numRunners);

        for (int i = 1; i <= numRunners; i++) {
            executor.submit(new Runner(i, startBarrier, finishLatch));
        }

        try {
            finishLatch.await(); 
            System.out.println("\nГонка завершена! Все участники пересекли финишную черту.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Наблюдение за гонкой прервано.");
        } finally {
            executor.shutdown(); 
        }
    }
}
