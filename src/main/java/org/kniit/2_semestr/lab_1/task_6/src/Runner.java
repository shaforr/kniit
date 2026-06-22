import java.util.concurrent.*;

 class Runner implements Runnable {
        private final int id;
        private final CyclicBarrier startBarrier;
        private final CountDownLatch finishLatch;

        public Runner(int id, CyclicBarrier startBarrier, CountDownLatch finishLatch) {
            this.id = id;
            this.startBarrier = startBarrier;
            this.finishLatch = finishLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Бегун " + id + " готовится на старте...");
                
                startBarrier.await();

                int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
                Thread.sleep(runTime);

                System.out.println("Бегун " + id + " финишировал за " + runTime + " мс!");
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Бегун " + id + " прервал забег.");
            } 
            catch (BrokenBarrierException e) {
                System.err.println("Барьер сломан для бегуна " + id + " (кто-то прерван или вышел с ошибкой).");
            } 
            finally {
                finishLatch.countDown();
            }
        }
    }
