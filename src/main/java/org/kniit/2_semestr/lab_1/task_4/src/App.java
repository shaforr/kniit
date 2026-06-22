public class App {
    public static void main(String[] args) throws Exception {
        TrafficLight signal = new TrafficLight();

        lightTimer timer = new lightTimer(signal);
        Thread timerThread = new Thread(timer);
        timerThread.start();

        for (int i = 1; i <= 15; i++) {
            Car car = new Car(signal, i);
            Thread carThread = new Thread(car);
            carThread.start();

            try { 
                Thread.sleep(1000); 
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            } 
            
        }
    }
}
