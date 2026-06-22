public class Producer implements Runnable{
    private final Store store;
    private final int count;
    public Producer(Store store, int count)
    {
        this.store = store;
        this.count = count;
    }

    @Override
    public void run()
    {
    for (int i = 1; i <= count; i++) {
        try {
            store.put(); 
            Thread.sleep(500);
            } 
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    }
}

