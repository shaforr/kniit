public class Store {

    private int product=0;
    private int maxProduct=5;

    public synchronized void get() throws InterruptedException
    {
        while (product < 0)
        {
            wait();
        }
        product--;
        System.out.println("Покупаетль взял товар на складе");
        System.out.println("Товаров осталось:" + product);
        System.out.println("");
        notify();
    }
    public synchronized void put() throws InterruptedException
    {
        while (product >= 5)
        {
            wait();
        }
        product++;
        System.out.println("Производитель положил товар на склад");
        System.out.println("Товаров на складе: " + product);
        System.out.println("");
        notify();
    }

}
