public class Cooker implements Runnable {
    private final Tray tray;
    private final int totalDishes;
    private int currentDishes = 0;

    public Cooker(Tray tray, int totalDishes) {
        this.tray = tray;
        this.totalDishes = totalDishes;
    }

        

    
    @Override
    public void run(){
        for (int i = 1; i <= totalDishes; i++)
        {
        try {
            tray.put(); 
            Thread.sleep(1000);
            } 
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    }
}
