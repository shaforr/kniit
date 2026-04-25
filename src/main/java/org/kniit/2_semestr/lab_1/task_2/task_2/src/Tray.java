public class Tray {
    private int count = 0;          
    private final int maxCapacity = 3;

    public synchronized void put() throws InterruptedException{
        while (count == maxCapacity){
            wait();
        }
        count++;
        System.out.println("Повар положил блюдо");
        System.out.println("На подносе " + count + " блюд");
        System.out.println("");
        notify(); 
    }

    public synchronized void take() throws InterruptedException{
        while (count == 0){
            wait();
        }

        System.out.println("Официант взял блюдо");
        count--;
        System.out.println("На подносе осталось "+ count + " блюд");
        System.out.println("");
        notify(); 
    }

}
