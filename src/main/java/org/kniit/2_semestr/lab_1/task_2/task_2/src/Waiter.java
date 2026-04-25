public class Waiter implements Runnable{
    private final Tray tray;
    private final int totalDishes;

    public Waiter(Tray tray, int totalDishes){
        this.tray = tray;
        this.totalDishes = totalDishes;
    }


    @Override
    public void run(){
        for (int i = 1; i <= totalDishes; i++)
        {
            try {
               tray.take(); 
               Thread.sleep(2000);
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
    }
}
