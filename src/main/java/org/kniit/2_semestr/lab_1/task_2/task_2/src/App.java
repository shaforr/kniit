public class App {
    public static void main(String[] args) throws Exception {
        Tray tray = new Tray();
        int totalDishes = 10;

        Cooker cooker = new Cooker(tray, totalDishes);
        Waiter waiter = new Waiter(tray, totalDishes);

        Thread cookerThread = new Thread(cooker);
        Thread waiterThread = new Thread(waiter);

        cookerThread.start();
        waiterThread.start();

        try {
            cookerThread.join();
            waiterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа ресторана завершена.");
    }
    }

