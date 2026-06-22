public class Consumer implements  Runnable{
    private final Store store;
    private final int count;

    public Consumer(Store store, int count)
    {
        this.store = store;
        this.count = count;
    }

    @Override
    public void run()
    {
    for (int i = 1; i <= count; i++) {
            try {
                store.get(); 
                Thread.sleep(2000);
                } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }
        }
    }
    }
