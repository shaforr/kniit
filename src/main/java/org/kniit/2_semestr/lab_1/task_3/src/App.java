public class App {
    public static void main(String[] args) throws Exception {
        Store store = new Store();

        int totalProducts = 20;
        Producer producer = new Producer(store, totalProducts);
        Consumer consumer = new Consumer(store, totalProducts);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
        try{
            producerThread.join();  
            consumerThread.join();
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
