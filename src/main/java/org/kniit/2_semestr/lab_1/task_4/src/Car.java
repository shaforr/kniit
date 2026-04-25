public class Car implements Runnable{

    private TrafficLight signal;
    private int carId;

    public Car(TrafficLight signal, int carId) {
        this.signal = signal;
        this.carId = carId;
    }
    @Override
    public void run() {
        try {
            signal.checkLight(carId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
