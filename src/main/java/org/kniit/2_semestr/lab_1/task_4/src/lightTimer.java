public class lightTimer implements Runnable{
    
    private TrafficLight signal;

    public lightTimer(TrafficLight signal)
    {
        this.signal = signal;
    }

    @Override
    public void run() {
        while (true) { 
            try {
                Thread.sleep(5000); 
                signal.changeLight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
